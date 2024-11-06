package kz.singularity.jetpackcomposemost.presentation.users.screens

import LoadingState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.singularity.jetpackcomposemost.presentation.users.viewmodels.UsersViewModel
import kz.singularity.jetpackcomposemost.presentation.users.contents.UserProfileContent

@Composable
fun UserProfileScreen(userId: String?) {

    val viewModel: UsersViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val userIdInt = userId?.toIntOrNull()
    val user = userIdInt?.let { id -> state.users.find { it.id == id } }

    if (user != null) {
        UserProfileContent(user)
    } else {
        LoadingState()
    }
}

