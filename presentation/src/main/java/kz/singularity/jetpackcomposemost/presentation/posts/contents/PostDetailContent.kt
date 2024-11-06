package kz.singularity.jetpackcomposemost.presentation.posts.contents

import InfoRow
import LoadingState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.domain.model.Post
import kz.singularity.jetpackcomposemost.presentation.posts.viewmodels.PostState
import kz.singularity.jetpackcomposemost.presentation.ui.components.CommentCard

@Composable
fun PostDetailContent(
    postState: PostState,
    postId: Int,
    author: String,
    navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        val post = postState.posts.find { it.id == postId }
        val comments = postState.comments[postId]
        if (postState.isLoadingComments || post == null || comments == null) {
            LoadingState()
        } else {
            PostDetailItem(
                post = post,
                comments = comments,
                author = author,
                navHostController = navHostController
            )
        }
    }
}


@Composable
fun PostDetailItem(
    post: Post,
    comments: List<Comment>,
    author: String,
    navHostController: NavHostController) {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = post.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        InfoRow(
            label = "By",
            value = author,
            labelColor = Color.Black,
            valueColor = Color.Magenta
        )
        Text(
            text = post.body,
            fontSize = 16.sp,
            color = Color.Black
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = "Comments",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Show All",
                fontSize = 16.sp,
                color = Color.Blue,
                modifier = Modifier.clickable {
                    navHostController.navigate("posts/postDetail/comments/${post.id}")
                }
            )
        }
        CommentCard(
            title = comments.first().name,
            body = comments.first().body,
            email = comments.first().email
        )
    }
}