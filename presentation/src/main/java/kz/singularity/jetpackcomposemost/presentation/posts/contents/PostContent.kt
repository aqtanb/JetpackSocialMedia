package kz.singularity.jetpackcomposemost.presentation.posts.contents

import LoadingState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.domain.model.Post
import kz.singularity.jetpackcomposemost.presentation.posts.viewmodels.PostState
import kz.singularity.jetpackcomposemost.presentation.ui.components.PostCard

@Composable
fun PostContent(state: PostState, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        if(state.isLoading) {
            LoadingState()
        } else {
            PostList(state = state, navController)
        }
    }
}

@Composable
fun PostList(state: PostState, navController: NavHostController) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        items(state.posts) { item ->
            PostCard(
                title = item.title,
                body = item.body,
                modifier = Modifier.clickable {
                    navController.navigate("postDetail/${item.id}/${item.userId}")
                }

            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PostContentPreview() {
    PostContent(
        state = PostState(
            posts = listOf(
                Post(
                    userId = 1,
                    id = 1,
                    title = "Sample Post Title",
                    body = "This is a sample post body for preview purposes."
                ),
                Post(
                    userId = 2,
                    id = 2,
                    title = "Another Sample Post",
                    body = "Here is another sample post body to showcase multiple items."
                )
            ),
            comments = mapOf(
                1 to listOf(
                    Comment(
                        postId = 1,
                        id = 1,
                        name = "Sample Commenter",
                        email = "sample@example.com",
                        body = "This is a sample comment body."
                    )
                ),
                2 to listOf(
                    Comment(
                        postId = 2,
                        id = 2,
                        name = "Another Commenter",
                        email = "another@example.com",
                        body = "Another comment for a different post."
                    )
                )
            ),
            isLoading = false
        ),
        rememberNavController()
    )
}
