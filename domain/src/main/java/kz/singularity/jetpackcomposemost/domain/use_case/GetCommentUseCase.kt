package kz.singularity.jetpackcomposemost.domain.use_case

import kz.singularity.jetpackcomposemost.domain.model.Comment

interface GetCommentUseCase {
    suspend fun invoke(postId: Int): List<Comment>
}