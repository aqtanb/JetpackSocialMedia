//package kz.singularity.jetpackcomposemost.presentation.posts
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import kz.singularity.jetpackcomposemost.domain.model.Address
//import kz.singularity.jetpackcomposemost.domain.model.Company
//import kz.singularity.jetpackcomposemost.domain.model.Geo
//import kz.singularity.jetpackcomposemost.domain.model.User
//
//@Composable
//fun UsersContent(state: UsersState) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background)
//    ) {
//        if (state.isLoading) {
//            LoadingState()
//        } else {
//            UsersList(users = state.users)
//        }
//    }
//}
//
//@Composable
//fun LoadingState() {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        CircularProgressIndicator()
//    }
//}
//
//@Composable
//fun UsersList(users: List<User>) {
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        contentPadding = PaddingValues(16.dp)
//    ) {
//        items(users.size) { index ->
//            User(users[index])
//        }
//    }
//}
//
//@Composable
//fun User(user: User) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(8.dp))
//            .padding(16.dp)
//    ) {
//        Text(text = user.name, color = MaterialTheme.colorScheme.onSurface)
//        Spacer(modifier = Modifier.size(16.dp))
//        Text(text = user.email, color = MaterialTheme.colorScheme.error)
//    }
//}
//
//@Preview(s)
//@Composable
//fun UsersContentPreview() {
//    UsersContent(
//        state = UsersState(
//            users = listOf(
//                User(
//                    avatar = "",
//                    email = "some@gmail.com",
//                    id = 1,
//                    name = "Leanne Graham",
//                    username = "Bret",
//                    address = Address(
//                        street = "Kulas Light",
//                        suite = "Apt. 556",
//                        city = "Gwenborough",
//                        zipcode = "92998-3874",
//                        geo = Geo(lat = "-37.3159", lng = "81.1496")
//                    ),
//                    phone = "1-770-736-8031 x56442",
//                    website = "hildegard.org",
//                    company = Company(
//                        name = "Romaguera-Crona",
//                        catchPhrase = "Multi-layered client-server neural-net",
//                        bs = "harness real-time e-markets"
//                    )
//                ),
//                User(
//                    avatar = "",
//                    email = "another@gmail.com",
//                    id = 2,
//                    name = "John Doe",
//                    username = "johnny",
//                    address = Address(
//                        street = "Main St",
//                        suite = "Apt. 1",
//                        city = "Somewhere",
//                        zipcode = "12345",
//                        geo = Geo(lat = "0.0000", lng = "0.0000")
//                    ),
//                    phone = "123-456-7890",
//                    website = "johndoe.com",
//                    company = Company(
//                        name = "Doe Industries",
//                        catchPhrase = "Innovation for tomorrow",
//                        bs = "tech solutions"
//                    )
//                )
//            ),
//            isLoading = false
//        )
//    )
//}
