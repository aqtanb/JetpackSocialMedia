package kz.singularity.jetpackcomposemost.presentation.profile

import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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