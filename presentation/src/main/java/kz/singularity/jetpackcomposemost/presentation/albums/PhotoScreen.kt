package kz.singularity.jetpackcomposemost.presentation.albums

import LoadingState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun PhotoScreen(albumId: String?, username: String?) {
    val viewModel = hiltViewModel<AlbumViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val albumIdInt = albumId?.toIntOrNull()
    if (albumIdInt != null) {
        PhotoContent(state = state, username = username, albumIdInt)
    } else {
        LoadingState()
    }
}