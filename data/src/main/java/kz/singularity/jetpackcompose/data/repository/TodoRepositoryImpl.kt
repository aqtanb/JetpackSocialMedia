package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.services.TodoService
import kz.singularity.jetpackcomposemost.domain.model.Todo
import kz.singularity.jetpackcomposemost.domain.repository.TodoRepository
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoService: TodoService
): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoService.getTodos()
    }
}