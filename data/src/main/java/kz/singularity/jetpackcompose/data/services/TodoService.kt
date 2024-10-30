package kz.singularity.jetpackcompose.data.services

import kz.singularity.jetpackcomposemost.domain.model.Todo
import retrofit2.http.GET

interface TodoService {
    @GET("todos/")
    suspend fun getTodos(): List<Todo>
}