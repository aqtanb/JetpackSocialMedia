package kz.singularity.jetpackcomposemost.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ProfileContent(
        state = state,
        navController = navController
    )
}