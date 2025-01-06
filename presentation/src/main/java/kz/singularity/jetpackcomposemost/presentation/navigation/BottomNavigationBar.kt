package kz.singularity.jetpackcomposemost.presentation.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kz.singularity.jetpackcomposemost.util.UIConstants

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        UIConstants.BottomNavItems.forEach { navItem ->
            val isSelected = currentRoute?.startsWith(navItem.route) == true
            val color = if (isSelected) Color.Magenta else Color.Gray
            BottomNavigationItem(
                label = {
                    Text(
                        text = stringResource(id = navItem.label),
                        color = color
                    )
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = stringResource(id = navItem.label),
                        tint = color
                    )
                },
                selected = isSelected,
                onClick = {
                    if (currentRoute != navItem.route) {
                        navController.navigate(navItem.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )

        }
    }
}