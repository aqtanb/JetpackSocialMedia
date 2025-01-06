package kz.singularity.jetpackcomposemost.presentation.users

import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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

