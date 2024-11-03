package kz.singularity.jetpackcomposemost.domain.repository

import kz.singularity.jetpackcomposemost.domain.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}