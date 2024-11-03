package kz.singularity.jetpackcomposemost.domain.repository

import kz.singularity.jetpackcomposemost.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}