package kz.singularity.jetpackcomposemost.presentation.posts

import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.singularity.jetpackcomposemost.domain.model.Comment
import kz.singularity.jetpackcomposemost.presentation.ui.components.CommentCard
import kz.singularity.presentation.R

@Composable
fun CommentContent(postState: PostState, comments: List<Comment>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        if (postState.isLoadingComments) {
            LoadingState()
        } else {
            CommentList(comments = comments)
        }
    }
}

@Composable
fun CommentList(comments: List<Comment>) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.comments),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(4.dp)
            )
        }

        items(comments) { comment ->
            CommentCard(title = comment.name, body = comment.body, email = comment.email)
        }
    }
}