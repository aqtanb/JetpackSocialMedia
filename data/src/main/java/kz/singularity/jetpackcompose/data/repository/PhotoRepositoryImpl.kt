package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.services.PhotoService
import kz.singularity.jetpackcomposemost.domain.model.Photo
import kz.singularity.jetpackcomposemost.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoService: PhotoService
): PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return photoService.getPhotos()
    }
}