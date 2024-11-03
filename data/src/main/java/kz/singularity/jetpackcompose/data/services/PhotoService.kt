package kz.singularity.jetpackcompose.data.services

import kz.singularity.jetpackcomposemost.domain.model.Photo
import retrofit2.http.GET

interface PhotoService {

    @GET("photos/")
    suspend fun getPhotos(): List<Photo>
}