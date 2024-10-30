package kz.singularity.jetpackcomposemost.domain.repository

import kz.singularity.jetpackcomposemost.domain.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
}