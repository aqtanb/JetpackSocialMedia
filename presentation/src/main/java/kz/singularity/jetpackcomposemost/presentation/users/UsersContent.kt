package kz.singularity.jetpackcomposemost.presentation.users

import kz.singularity.jetpackcomposemost.presentation.ui.components.InfoRow
import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
import android.content.Intent
import android.net.Uri
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.singularity.jetpackcomposemost.domain.model.Address
import kz.singularity.jetpackcomposemost.domain.model.Company
import kz.singularity.jetpackcomposemost.domain.model.Geo
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.util.Routes
import kz.singularity.presentation.R

@Composable
fun UsersContent(state: UsersState, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        if (state.isLoading) {
            LoadingState()
        } else {
            UsersList(users = state.users, navController)
        }
    }
}

@Composable
fun UsersList(users: List<User>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.users),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(4.dp)
            )
        }

        items(users) { user ->
            UserItem(user, navController)
        }
    }
}

@Composable
fun UserItem(user: User, navController: NavController) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(
                    Routes.USER_PROFILE.replace("{userId}", user.id.toString())
                )
            }

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
                text = user.username,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            InfoRow(
                label = stringResource(R.string.full_name),
                value = user.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.email),
                value = user.email,
                labelColor = Color.Gray,
                valueColor = Color.Blue,
                modifier = Modifier.clickable {
                    val emailIntent =
                        Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:${user.email}")
                        }
                    context.startActivity(emailIntent)
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
                User(
                    avatar = "",
                    email = "some@gmail.com",
                    id = 1,
                    name = "Leanne Graham",
                    username = "Bret",
                    address = Address(
                        street = "Kulas Light",
                        suite = "Apt. 556",
                        city = "Gwenborough",
                        zipcode = "92998-3874",
                        geo = Geo(lat = "-37.3159", lng = "81.1496")
                    ),
                    phone = "1-770-736-8031 x56442",
                    website = "hildegard.org",
                    company = Company(
                        name = "Romaguera-Crona",
                        catchPhrase = "Multi-layered client-server neural-net",
                        bs = "harness real-time e-markets"
                    )
                ),
                User(
                    avatar = "",
                    email = "another@gmail.com",
                    id = 2,
                    name = "John Doe",
                    username = "johnny",
                    address = Address(
                        street = "Main St",
                        suite = "Apt. 1",
                        city = "Somewhere",
                        zipcode = "12345",
                        geo = Geo(lat = "0.0000", lng = "0.0000")
                    ),
                    phone = "123-456-7890",
                    website = "johndoe.com",
                    company = Company(
                        name = "Doe Industries",
                        catchPhrase = "Innovation for tomorrow",
                        bs = "tech solutions"
                    )
                )
            ),
            isLoading = false
        ),
        navController = navController
    )
}

