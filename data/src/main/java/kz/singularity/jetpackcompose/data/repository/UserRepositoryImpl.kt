package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.services.UserService
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userService.getUsers()
        // TODO: Get User
    }
}