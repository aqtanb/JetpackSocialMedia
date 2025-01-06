package kz.singularity.jetpackcomposemost.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: Int,
    val icon: ImageVector,
    val route: String,
)