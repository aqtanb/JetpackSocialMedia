package kz.singularity.jetpackcomposemost.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kz.singularity.jetpackcomposemost.presentation.albums.AlbumScreen
import kz.singularity.jetpackcomposemost.presentation.albums.PhotoScreen
import kz.singularity.jetpackcomposemost.presentation.posts.CommentScreen
import kz.singularity.jetpackcomposemost.presentation.posts.PostDetailScreen
import kz.singularity.jetpackcomposemost.presentation.posts.PostScreen
import kz.singularity.jetpackcomposemost.presentation.profile.ProfileScreen
import kz.singularity.jetpackcomposemost.presentation.profile.TodoScreen
import kz.singularity.jetpackcomposemost.presentation.users.UserProfileScreen
import kz.singularity.jetpackcomposemost.presentation.users.UsersScreen
import kz.singularity.jetpackcomposemost.util.Routes

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Routes.POSTS,
        modifier = Modifier.padding(padding),
    ) {
        composable(Routes.POSTS) {
            PostScreen(navController)
        }

        composable(Routes.POST_DETAIL) { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            val userId = backStackEntry.arguments?.getString("userId")
            PostDetailScreen(postId, userId, navController)
        }

        composable(Routes.COMMENTS) { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            CommentScreen(postId)
        }

        composable(Routes.ALBUMS) {
            AlbumScreen(navController)
        }

        composable(Routes.PHOTOS) { backStackEntry ->
            val albumId = backStackEntry.arguments?.getString("albumId")
            val username = backStackEntry.arguments?.getString("username")
            PhotoScreen(albumId, username)
        }

        composable(Routes.USERS) {
            UsersScreen(navController)
        }

        composable(Routes.USER_PROFILE) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserProfileScreen(userId)
        }

        composable(Routes.PROFILE) {
            ProfileScreen(navController)
        }

        composable(Routes.TODOS) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            TodoScreen(userId)
        }
    }
}