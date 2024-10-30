package kz.singularity.jetpackcomposemost.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kz.singularity.jetpackcompose.data.repository.TodoRepositoryImpl
import kz.singularity.jetpackcompose.data.repository.UserRepositoryImpl
import kz.singularity.jetpackcompose.data.use_case.GetTodosUseCaseImpl
import kz.singularity.jetpackcompose.data.use_case.GetUsersUseCaseImpl
import kz.singularity.jetpackcomposemost.domain.repository.TodoRepository
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetTodosUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetUsersUseCase

@Module
@InstallIn(ViewModelComponent::class)
interface BindingModule {

    @Binds
    fun bindsUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindsGetUsersUseCase(impl: GetUsersUseCaseImpl): GetUsersUseCase

    @Binds
    fun bindsTodoRepository(impl: TodoRepositoryImpl): TodoRepository

    @Binds
    fun bindsGetTodoUseCase(impl: GetTodosUseCaseImpl): GetTodosUseCase

}