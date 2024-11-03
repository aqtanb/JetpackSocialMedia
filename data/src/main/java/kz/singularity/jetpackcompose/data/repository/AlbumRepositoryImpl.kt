package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.services.AlbumService
import kz.singularity.jetpackcomposemost.domain.model.Album
import kz.singularity.jetpackcomposemost.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumService: AlbumService
): AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return albumService.getAlbums()
    }
}