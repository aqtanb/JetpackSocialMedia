package kz.singularity.jetpackcompose.data.use_case

import kz.singularity.jetpackcomposemost.domain.model.Photo
import kz.singularity.jetpackcomposemost.domain.repository.PhotoRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetPhotoUseCase
import javax.inject.Inject

class GetPhotoUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
): GetPhotoUseCase {
    override suspend fun invoke(): List<Photo> {
        return photoRepository.getPhotos()
    }
}