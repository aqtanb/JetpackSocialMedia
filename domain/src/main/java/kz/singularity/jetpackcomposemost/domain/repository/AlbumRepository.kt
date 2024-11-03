package kz.singularity.jetpackcomposemost.domain.repository

import kz.singularity.jetpackcomposemost.domain.model.Album

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
}