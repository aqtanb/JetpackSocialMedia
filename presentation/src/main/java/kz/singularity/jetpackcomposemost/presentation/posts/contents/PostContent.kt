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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
        if(state.isLoadingPosts) {
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
