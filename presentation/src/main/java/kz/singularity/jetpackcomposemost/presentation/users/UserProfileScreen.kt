package kz.singularity.jetpackcomposemost.presentation.users

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserProfileScreen(userId: String?) {
    Text(text = "User Profile for User ID: $userId")
}
