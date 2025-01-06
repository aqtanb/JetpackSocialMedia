package kz.singularity.jetpackcomposemost.presentation.posts

import kz.singularity.jetpackcomposemost.presentation.ui.components.InfoRow
import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.domain.model.Post
import kz.singularity.jetpackcomposemost.presentation.ui.components.CommentCard
import kz.singularity.jetpackcomposemost.util.Routes
import kz.singularity.presentation.R

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
            label = stringResource(R.string.by),
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
                text = stringResource(R.string.comments),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.show_all),
                fontSize = 16.sp,
                color = Color.Blue,
                modifier = Modifier.clickable {
                    navHostController.navigate(
                        Routes.COMMENTS.replace("{postId}", post.id.toString())
                    )

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