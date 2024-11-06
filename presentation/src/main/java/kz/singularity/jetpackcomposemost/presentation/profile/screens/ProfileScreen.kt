package kz.singularity.jetpackcomposemost.presentation.profile.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kz.singularity.jetpackcomposemost.presentation.profile.viewmodels.ProfileViewModel
import kz.singularity.jetpackcomposemost.presentation.profile.contents.ProfileContent

@Composable
fun ProfileScreen(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ProfileContent(
        state = state,
        navController = navController
    )
}