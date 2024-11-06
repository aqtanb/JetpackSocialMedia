
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kz.singularity.jetpackcomposemost.presentation.albums.screens.AlbumScreen
import kz.singularity.jetpackcomposemost.presentation.albums.screens.PhotoScreen
import kz.singularity.jetpackcomposemost.presentation.posts.screens.CommentScreen
import kz.singularity.jetpackcomposemost.presentation.posts.screens.PostDetailScreen
import kz.singularity.jetpackcomposemost.presentation.posts.screens.PostScreen
import kz.singularity.jetpackcomposemost.presentation.profile.screens.ProfileScreen
import kz.singularity.jetpackcomposemost.presentation.profile.screens.TodoScreen
import kz.singularity.jetpackcomposemost.presentation.users.screens.UserProfileScreen
import kz.singularity.jetpackcomposemost.presentation.users.screens.UsersScreen

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

        composable("posts/postDetail/{postId}/{userId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            val userId = backStackEntry.arguments?.getString("userId")
            PostDetailScreen(postId, userId, navController)
        }

        composable("posts/postDetail/comments/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            CommentScreen(postId)
        }

        composable("albums") {
            AlbumScreen(navController)
        }

        composable("albums/photos/{albumId}/{username}") { backStackEntry ->
            val albumId = backStackEntry.arguments?.getString("albumId")
            val username = backStackEntry.arguments?.getString("username")
            PhotoScreen(albumId, username)
        }

        composable("users") {
            UsersScreen(navController)
        }

        composable("users/userProfile/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserProfileScreen(userId)
        }

        composable("profile") {
            ProfileScreen(navController)
        }

        composable("profile/todos/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            TodoScreen(userId)
        }
    }

}