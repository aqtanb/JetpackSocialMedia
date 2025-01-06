package kz.singularity.jetpackcomposemost.presentation.posts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun PostScreen(navController: NavHostController) {
    val postViewModel = hiltViewModel<PostViewModel>()
    val state by postViewModel.state.collectAsStateWithLifecycle()

    PostContent(
        state = state,
        navController = navController
    )
}