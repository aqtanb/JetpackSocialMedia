package kz.singularity.jetpackcomposemost.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import kz.singularity.jetpackcomposemost.presentation.navigation.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Posts",
            icon = Icons.Filled.Home,
            route = "posts"
        ),
        BottomNavItem(
            label = "Albums",
            icon = Icons.Filled.Menu,
            route = "albums"
        ),
        BottomNavItem(
            label = "Users",
            icon = Icons.Filled.Email,
            route = "users"
        ),
        BottomNavItem(
            label = "Profile",
            icon = Icons.Filled.AccountCircle,
            route = "profile"
        )
    )
}
