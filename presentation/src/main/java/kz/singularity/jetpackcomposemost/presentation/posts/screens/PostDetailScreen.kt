package kz.singularity.jetpackcomposemost.presentation.posts.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.presentation.posts.contents.PostDetailContent
import kz.singularity.jetpackcomposemost.presentation.posts.viewmodels.PostViewModel
import kz.singularity.jetpackcomposemost.presentation.users.UsersViewModel

@Composable
fun PostDetailScreen(
    postId: String?,
    userId: String?,
    navHostController: NavHostController,
    postViewModel: PostViewModel = hiltViewModel(),
    usersViewModel: UsersViewModel = hiltViewModel()
) {
    val postState by postViewModel.state.collectAsStateWithLifecycle()
    val userState by usersViewModel.state.collectAsStateWithLifecycle()

    val postIdInt = postId?.toIntOrNull()
    val userIdInt = userId?.toIntOrNull()

    val post = postState.posts.find { it.id == postIdInt }
    val postComments = postState.comments[postIdInt] ?: emptyList()
    val user = userState.users.find { it.id == userIdInt }

    if (post != null && user != null) {
        PostDetailContent(
            post = post,
            comments = postComments,
            author = user.name,
            isLoading = false,
            navHostController
            )
    }

}
