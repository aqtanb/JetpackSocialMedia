package kz.singularity.jetpackcompose.data.use_case

import kz.singularity.jetpackcomposemost.domain.model.Album
import kz.singularity.jetpackcomposemost.domain.repository.AlbumRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetAlbumUseCase
import javax.inject.Inject

class GetAlbumUseCaseImpl @Inject constructor(
    private val albumRepository: AlbumRepository
): GetAlbumUseCase {
    override suspend fun invoke(): List<Album> {
        return albumRepository.getAlbums()
    }
}