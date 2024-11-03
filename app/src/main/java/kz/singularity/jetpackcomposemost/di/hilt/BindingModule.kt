package kz.singularity.jetpackcomposemost.di.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kz.singularity.jetpackcompose.data.repository.AlbumRepositoryImpl
import kz.singularity.jetpackcompose.data.repository.CommentRepositoryImpl
import kz.singularity.jetpackcompose.data.repository.PhotoRepositoryImpl
import kz.singularity.jetpackcompose.data.repository.PostRepositoryImpl
import kz.singularity.jetpackcompose.data.repository.TodoRepositoryImpl
import kz.singularity.jetpackcompose.data.repository.UserRepositoryImpl
import kz.singularity.jetpackcompose.data.use_case.GetAlbumUseCaseImpl
import kz.singularity.jetpackcompose.data.use_case.GetCommentUseCaseImpl
import kz.singularity.jetpackcompose.data.use_case.GetPhotoUseCaseImpl
import kz.singularity.jetpackcompose.data.use_case.GetPostUseCaseImpl
import kz.singularity.jetpackcompose.data.use_case.GetTodosUseCaseImpl
import kz.singularity.jetpackcompose.data.use_case.GetUsersUseCaseImpl
import kz.singularity.jetpackcomposemost.domain.repository.AlbumRepository
import kz.singularity.jetpackcomposemost.domain.repository.CommentRepository
import kz.singularity.jetpackcomposemost.domain.repository.PhotoRepository
import kz.singularity.jetpackcomposemost.domain.repository.PostRepository
import kz.singularity.jetpackcomposemost.domain.repository.TodoRepository
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetAlbumUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetCommentUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetPhotoUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetPostUseCase
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



    @Binds
    fun bindsAlbumRepository(impl: AlbumRepositoryImpl): AlbumRepository

    @Binds
    fun bindsGetAlbumUseCase(impl: GetAlbumUseCaseImpl): GetAlbumUseCase



    @Binds
    fun bindsPhotoRepository(impl: PhotoRepositoryImpl): PhotoRepository

    @Binds
    fun bindsGetPhotoUseCase(impl: GetPhotoUseCaseImpl): GetPhotoUseCase



    @Binds
    fun bindsPostRepository(impl: PostRepositoryImpl): PostRepository

    @Binds
    fun bidsGetPostUseCase(impl: GetPostUseCaseImpl): GetPostUseCase



    @Binds
    fun bindsCommentRepository(impl: CommentRepositoryImpl): CommentRepository

    @Binds
    fun bindsGetCommentUseCase(impl: GetCommentUseCaseImpl): GetCommentUseCase

}