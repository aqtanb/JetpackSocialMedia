package kz.singularity.jetpackcomposemost.presentation.albums

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.presentation.users.UsersViewModel

@Composable
fun AlbumScreen(navController: NavHostController) {
    //TODO: One screen - one ViewModel
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
