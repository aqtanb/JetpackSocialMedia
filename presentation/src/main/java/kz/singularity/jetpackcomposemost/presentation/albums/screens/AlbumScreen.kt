package kz.singularity.jetpackcomposemost.presentation.albums.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.presentation.albums.contents.AlbumContent
import kz.singularity.jetpackcomposemost.presentation.albums.viewmodels.AlbumViewModel
import kz.singularity.jetpackcomposemost.presentation.users.viewmodels.UsersViewModel

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
