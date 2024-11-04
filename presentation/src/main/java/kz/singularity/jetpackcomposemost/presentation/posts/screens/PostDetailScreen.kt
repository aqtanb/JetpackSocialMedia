package kz.singularity.jetpackcomposemost.presentation.posts.screens

import android.util.Log
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
    navHostController: NavHostController
) {
    val postViewModel: PostViewModel = hiltViewModel()
    val usersViewModel: UsersViewModel = hiltViewModel()

    val postState by postViewModel.state.collectAsStateWithLifecycle()
    val userState by usersViewModel.state.collectAsStateWithLifecycle()

    val postIdInt = postId?.toIntOrNull()
    val userIdInt = userId?.toIntOrNull()
    Log.e("TAG", "Its in the postdetailsscreen")
    postIdInt?.let { validPostId ->
        userIdInt?.let { validUserId ->
            val post = postState.posts.find { it.id == validPostId }
            val postComments = postState.comments[validPostId]
            val user = userState.users.find { it.id == validUserId }

            Log.e("TAG", "post: $post, postComments: $postComments, user: $user")

            if (post != null && user != null && postComments != null) {
                PostDetailContent(
                    state = postState,
                    postId = validPostId,
                    author = user.name,
                    navHostController = navHostController
                )
            }
        }
    }

}
