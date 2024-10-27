package kz.singularity.jetpackcomposemost.presentation.users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.singularity.jetpackcomposemost.domain.model.User

@Composable
fun UsersContent(state: UsersState, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (state.isLoading) {
            LoadingState()
        } else {
            UsersList(users = state.users, navController)
        }
    }
}

@Composable
fun LoadingState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun UsersList(users: List<User>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(users) { user ->
            UserItem(user, navController)
        }
    }
}

@Composable
fun UserItem(user: User, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("userProfile/${user.id}") }
        ,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = user.name.substringBefore(" "),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color.Gray)) {
                        append("Full Name: ")
                    }
                    withStyle(style = SpanStyle(
                        color = Color.Black)) {
                        append(user.name)
                    }
                }
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color.Gray)) {
                        append("Email: ")
                    }
                    withStyle(style = SpanStyle(
                        color = Color.Blue)) {
                        append(user.email)
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UsersContentPreview() {
    val navController = rememberNavController()

    UsersContent(
        state = UsersState(
            users = listOf(
                User(avatar = "", email = "some@gmail.com", id = 0, name = "John Doe"),
                User(avatar = "", email = "some@gmail.com", id = 1, name = "Jane Doe"),
                User(avatar = "", email = "some@gmail.com", id = 2, name = "Alice Smith"),
                User(avatar = "", email = "some@gmail.com", id = 3, name = "Bob Brown"),
                User(avatar = "", email = "some@gmail.com", id = 4, name = "Charlie Black"),
                User(avatar = "", email = "some@gmail.com", id = 5, name = "David White"),
                User(avatar = "", email = "some@gmail.com", id = 6, name = "Eve Green"),
                User(avatar = "", email = "some@gmail.com", id = 7, name = "Frank Blue"),
            ),
            isLoading = false
        ),
        navController = navController
    )
}