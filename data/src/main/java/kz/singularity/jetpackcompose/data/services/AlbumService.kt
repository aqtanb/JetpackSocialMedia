package kz.singularity.jetpackcompose.data.services

import kz.singularity.jetpackcomposemost.domain.model.Album
import retrofit2.http.GET

interface AlbumService {

    @GET("albums/")
    suspend fun getAlbums(): List<Album>
}
