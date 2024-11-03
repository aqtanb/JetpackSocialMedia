package kz.singularity.jetpackcomposemost.domain.use_case

import kz.singularity.jetpackcomposemost.domain.model.Post

interface GetPostUseCase {
    suspend fun invoke(): List<Post>
}