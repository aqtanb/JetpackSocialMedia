package kz.singularity.jetpackcompose.data.services

import kz.singularity.jetpackcomposemost.domain.model.Comment
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentService {

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<Comment>
}