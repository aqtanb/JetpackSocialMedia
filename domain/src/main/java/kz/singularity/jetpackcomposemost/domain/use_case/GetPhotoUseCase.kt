package kz.singularity.jetpackcomposemost.domain.use_case

import kz.singularity.jetpackcomposemost.domain.model.Photo

interface GetPhotoUseCase {
    suspend fun invoke(): List<Photo>
}