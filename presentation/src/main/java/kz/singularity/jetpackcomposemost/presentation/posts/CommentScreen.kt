package kz.singularity.jetpackcomposemost.presentation.posts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.singularity.jetpackcomposemost.domain.model.Comment

@Composable
fun CommentScreen(postId: String?) {
    val postViewModel: PostViewModel = hiltViewModel()
    val postState by postViewModel.state.collectAsStateWithLifecycle()
    val postIdInt = postId?.toIntOrNull()
    val comments: List<Comment> = postState.comments[postIdInt] ?: emptyList()
    CommentContent(postState, comments = comments)
}