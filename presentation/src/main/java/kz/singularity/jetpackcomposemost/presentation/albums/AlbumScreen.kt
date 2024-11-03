package kz.singularity.jetpackcomposemost.presentation.posts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.presentation.albums.AlbumContent
import kz.singularity.jetpackcomposemost.presentation.albums.AlbumViewModel
import kz.singularity.jetpackcomposemost.presentation.users.UsersViewModel

@Composable
fun AlbumScreen(navController: NavHostController) {
    val albumViewModel = hiltViewModel<AlbumViewModel>()
    val userViewModel = hiltViewModel<UsersViewModel>()
    val albumState by albumViewModel.state.collectAsStateWithLifecycle()
    val userState by userViewModel.state.collectAsStateWithLifecycle()

    AlbumContent(
        state = albumState,
        navController = navController,
        users = userState.users
    )
}
