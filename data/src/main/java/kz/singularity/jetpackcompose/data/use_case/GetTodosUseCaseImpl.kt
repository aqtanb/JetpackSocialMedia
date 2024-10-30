package kz.singularity.jetpackcompose.data.use_case

import kz.singularity.jetpackcomposemost.domain.model.Todo
import kz.singularity.jetpackcomposemost.domain.repository.TodoRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetTodosUseCase
import javax.inject.Inject

class GetTodosUseCaseImpl @Inject constructor(
    private val todoRepository: TodoRepository
): GetTodosUseCase {
    override suspend fun invoke(): List<Todo> {
        return todoRepository.getTodos()
    }
}