package kz.singularity.jetpackcompose.data

import kz.singularity.jetpackcomposemost.domain.model.User
import retrofit2.http.GET

interface UserService {

    @GET("users/")
    suspend fun getUsers(): List<User>

}