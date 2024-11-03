
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kz.singularity.jetpackcomposemost.presentation.albums.PhotoScreen
import kz.singularity.jetpackcomposemost.presentation.posts.AlbumScreen
import kz.singularity.jetpackcomposemost.presentation.posts.screens.CommentScreen
import kz.singularity.jetpackcomposemost.presentation.posts.screens.PostDetailScreen
import kz.singularity.jetpackcomposemost.presentation.posts.screens.PostScreen
import kz.singularity.jetpackcomposemost.presentation.profile.ProfileScreen
import kz.singularity.jetpackcomposemost.presentation.profile.TodoScreen
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
            PostScreen(navController)
        }

        composable("albums") {
            AlbumScreen(navController)
        }

        composable("users") {
            UsersScreen(navController)
        }

        composable("profile") {
            ProfileScreen(navController)
        }

        composable("userProfile/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserProfileScreen(userId)
        }

        composable("todos/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            TodoScreen(userId)
        }

        composable("photos/{albumId}/{username}") { backStackEntry ->
            val albumId = backStackEntry.arguments?.getString("albumId")
            val username = backStackEntry.arguments?.getString("username")
            PhotoScreen(albumId, username)
        }

        composable("postDetail/{postId}/{userId}") { backstackEntry ->
            val postId = backstackEntry.arguments?.getString("postId")
            val userId = backstackEntry.arguments?.getString("userId")
            PostDetailScreen(postId, userId, navController)
        }

        composable("comments/{postId}") { backstackEntry ->
            val postId = backstackEntry.arguments?.getString("postId")
            CommentScreen(postId)
        }

    }
}