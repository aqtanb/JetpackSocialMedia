package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.services.PostService
import kz.singularity.jetpackcomposemost.domain.model.Post
import kz.singularity.jetpackcomposemost.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postService: PostService
): PostRepository {
    override suspend fun getPosts(): List<Post> {
        return postService.getPosts()
    }
}