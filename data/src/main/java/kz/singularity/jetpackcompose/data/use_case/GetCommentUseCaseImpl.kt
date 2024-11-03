package kz.singularity.jetpackcompose.data.use_case

import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.domain.repository.CommentRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetCommentUseCase
import javax.inject.Inject

class GetCommentUseCaseImpl @Inject constructor(
    private val commentRepository: CommentRepository
): GetCommentUseCase {
    override suspend fun invoke(postId: Int): List<Comment> {
        return commentRepository.getComments(postId)
    }
}