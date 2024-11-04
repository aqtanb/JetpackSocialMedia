package kz.singularity.jetpackcomposemost.presentation.posts.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.domain.model.Post
import kz.singularity.jetpackcomposemost.domain.use_case.GetCommentUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetPostUseCase
import javax.inject.Inject

data class PostState (
    val posts: List<Post> = emptyList(),
    val comments: Map<Int, List<Comment>> = emptyMap(),
    val isLoadingPosts: Boolean = true,
    val isLoadingComments: Boolean = true
)

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getCommentUseCase: GetCommentUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(PostState())
    val state: StateFlow<PostState> = _state

    init {
        loadPost()
    }


    private fun loadPost() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = getPostUseCase.invoke()
            _state.value = _state.value.copy(posts = posts, isLoadingPosts = false)
            loadComment()
        }
    }

    private fun loadComment() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = _state.value.posts

            if (posts.isNotEmpty()) {
                val commentsMap = posts.associate { post ->
                    post.id to getCommentUseCase.invoke(post.id)
                }
                _state.value = _state.value.copy(comments = commentsMap, isLoadingComments = false)
            }
        }
    }
}