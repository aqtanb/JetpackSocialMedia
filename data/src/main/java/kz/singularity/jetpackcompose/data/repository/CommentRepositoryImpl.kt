package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.services.CommentService
import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentService: CommentService
): CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return commentService.getComments(postId)
    }
}