package kz.singularity.jetpackcomposemost.domain.use_case

import kz.singularity.jetpackcomposemost.domain.model.Album

interface GetAlbumUseCase {
    suspend fun invoke(): List<Album>
}