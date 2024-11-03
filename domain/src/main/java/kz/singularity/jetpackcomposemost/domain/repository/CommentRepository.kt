package kz.singularity.jetpackcomposemost.domain.repository

import kz.singularity.jetpackcomposemost.domain.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}