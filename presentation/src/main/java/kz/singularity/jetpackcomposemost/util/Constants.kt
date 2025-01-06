package kz.singularity.jetpackcomposemost.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.res.stringResource
import kz.singularity.jetpackcomposemost.presentation.navigation.BottomNavItem
import kz.singularity.presentation.R



object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            icon = Icons.Filled.Home,
            route = Routes.POSTS,
            label = R.string.posts
        ),
        BottomNavItem(
            icon = Icons.Filled.Menu,
            route = Routes.ALBUMS,
            label = R.string.albums
        ),
        BottomNavItem(
            icon = Icons.Filled.Email,
            route = Routes.USERS,
            label = R.string.users
        ),
        BottomNavItem(
            icon = Icons.Filled.AccountCircle,
            route = Routes.PROFILE,
            label = R.string.profile
        )
    )
}
