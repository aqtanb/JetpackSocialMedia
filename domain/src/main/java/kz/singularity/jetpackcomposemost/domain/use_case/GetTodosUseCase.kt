package kz.singularity.jetpackcomposemost.domain.use_case

import kz.singularity.jetpackcomposemost.domain.model.Todo

interface GetTodosUseCase {
    suspend fun invoke(): List<Todo>
}