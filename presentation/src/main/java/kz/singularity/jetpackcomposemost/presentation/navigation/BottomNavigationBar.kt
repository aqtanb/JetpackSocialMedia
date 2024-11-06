
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kz.singularity.jetpackcomposemost.util.Constants

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
    ) {


        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route


        Constants.BottomNavItems.forEach { navItem ->


            BottomNavigationItem(
                selected = currentRoute?.startsWith(navItem.route) == true,
                onClick = {
                    if (currentRoute != navItem.route) {
                        navController.navigate(navItem.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.label,
                        tint = if (currentRoute?.startsWith(navItem.route) == true) Color.Magenta else Color.Gray // Change color based on selection
                    )
                },
                label = {
                    Text(text = navItem.label, color = if (currentRoute?.startsWith(navItem.route) == true) Color.Magenta else Color.Gray) // Change label color based on selection
                },
                alwaysShowLabel = false
            )
        }
    }
}