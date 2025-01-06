package kz.singularity.jetpackcomposemost.presentation.albums.screens

import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.singularity.jetpackcomposemost.presentation.albums.contents.PhotoContent
import kz.singularity.jetpackcomposemost.presentation.albums.viewmodels.AlbumViewModel


@Composable
fun PhotoScreen(albumId: String?, username: String?) {
    val viewModel = hiltViewModel<AlbumViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val albumIdInt = albumId?.toIntOrNull()
    if (albumIdInt != null) {
        PhotoContent(albumState = state, username = username, albumIdInt)
    } else {
        LoadingState()
    }
}