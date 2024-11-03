package kz.singularity.jetpackcompose.data.use_case

import kz.singularity.jetpackcomposemost.domain.model.Post
import kz.singularity.jetpackcomposemost.domain.repository.PostRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetPostUseCase
import javax.inject.Inject

class GetPostUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
): GetPostUseCase {
    override suspend fun invoke(): List<Post> {
        return postRepository.getPosts()
    }
}