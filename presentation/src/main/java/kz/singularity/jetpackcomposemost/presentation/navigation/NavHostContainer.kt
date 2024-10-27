import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kz.singularity.jetpackcomposemost.presentation.posts.AlbumsScreen
import kz.singularity.jetpackcomposemost.presentation.posts.PostsScreen
import kz.singularity.jetpackcomposemost.presentation.posts.ProfileScreen
import kz.singularity.jetpackcomposemost.presentation.users.UserProfileScreen
import kz.singularity.jetpackcomposemost.presentation.users.UsersScreen

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "posts",
        modifier = Modifier.padding(padding),
    ) {
        composable("posts") {
            PostsScreen()
        }

        composable("albums") {
            AlbumsScreen()
        }

        composable("users") {
            UsersScreen(navController)
        }

        composable("profile") {
            ProfileScreen()
        }
        composable("userProfile/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserProfileScreen(userId)
        }
    }
}