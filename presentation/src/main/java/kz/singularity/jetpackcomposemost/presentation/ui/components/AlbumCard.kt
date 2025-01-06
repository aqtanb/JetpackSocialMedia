package kz.singularity.jetpackcomposemost.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import kz.singularity.presentation.R

@Composable
fun AlbumCard(albumName: String, username: String, ratio: Float, modifier: Modifier = Modifier, imageUrl: String) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.background(color = Color.White)
        ) {
            val painter = rememberAsyncImagePainter(model = imageUrl)
            val painterState = painter.state

            Box(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio)) {
                Image(
                    painter = painter,
                    contentDescription = stringResource(R.string.album_image),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio),
                    contentScale = ContentScale.Crop
                )

                if (painterState is AsyncImagePainter.State.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(24.dp),
                        color = Color.Magenta
                    )
                }
                if (painterState is AsyncImagePainter.State.Error) {
                    Text(
                        text = stringResource(R.string.error_loading_image),
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(color = Color.White)
                    .height(54.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = albumName,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(5f),
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = username,
                    color = Color.Magenta,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(4f),
                    textAlign = TextAlign.Right,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}