package kz.singularity.jetpackcomposemost.presentation.profile.screens

import LoadingState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.singularity.jetpackcomposemost.presentation.profile.viewmodels.ProfileViewModel
import kz.singularity.jetpackcomposemost.presentation.profile.contents.TodoContent

@Composable
fun TodoScreen(userId: String?) {

    val viewModel = hiltViewModel<ProfileViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val userIdInt = userId?.toIntOrNull()
    if (userIdInt != null) {
        TodoContent(state = state, userId = userIdInt)
    } else {
        LoadingState()
    }
}