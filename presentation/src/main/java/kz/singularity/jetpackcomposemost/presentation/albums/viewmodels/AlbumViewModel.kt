package kz.singularity.jetpackcomposemost.presentation.albums.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.singularity.jetpackcomposemost.domain.model.Album
import kz.singularity.jetpackcomposemost.domain.model.Photo
import kz.singularity.jetpackcomposemost.domain.use_case.GetAlbumUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetPhotoUseCase
import javax.inject.Inject

data class AlbumState(
    val albums: List<Album> = emptyList(),
    val photos: List<Photo> = emptyList(),
    val isLoadingAlbums: Boolean = true,
    val isLoadingPhotos: Boolean = true
)

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getAlbumUseCase: GetAlbumUseCase,
    private val getPhotoUseCase: GetPhotoUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AlbumState())
    val state: StateFlow<AlbumState> = _state

    init {
        loadAlbums()
        loadPhotos()
    }

    private fun loadAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            val receivedAlbums = getAlbumUseCase.invoke()
            _state.value = _state.value.copy(albums = receivedAlbums, isLoadingAlbums = false)
        }
    }

    private fun loadPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            val receivedPhotos = getPhotoUseCase.invoke()
            _state.value = _state.value.copy(photos = receivedPhotos, isLoadingPhotos = false)
        }
    }
}