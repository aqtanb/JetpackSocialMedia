package kz.singularity.jetpackcomposemost.presentation.albums.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.singularity.jetpackcomposemost.domain.model.Photo
import kz.singularity.jetpackcomposemost.presentation.albums.viewmodels.AlbumState
import kz.singularity.jetpackcomposemost.presentation.ui.components.AlbumCard

@Composable
fun PhotoContent(albumState: AlbumState, username: String?, albumIdInt: Int) {
    var isGrid by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {

        val photos = albumState.photos.filter { it.albumId == albumIdInt }

        if (isGrid) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item (span = { GridItemSpan(2)}) {
                    PhotoInfo(
                        albumState = albumState,
                        username = username,
                        albumIdInt = albumIdInt,
                        onToggleGrid = { isGrid = !isGrid },
                        isGrid = isGrid
                    )
                }
                items(photos) { photo ->
                    AlbumCard(
                        albumName = photo.title,
                        username = "",
                        ratio = 4 / 4f,
                        imageUrl = photo.thumbnailUrl
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp)
            ) {

                item {
                    PhotoInfo(
                        albumState = albumState,
                        username = username,
                        albumIdInt = albumIdInt,
                        onToggleGrid = { isGrid = !isGrid },
                        isGrid = isGrid
                    )
                }

                items(photos) { photo ->
                    AlbumCard(
                        albumName = photo.title,
                        username = "",
                        ratio = 16 / 9f,
                        imageUrl = photo.url
                    )
                }
            }
        }

    }
}

@Composable
fun PhotoInfo(
    albumState: AlbumState,
    username: String?,
    albumIdInt: Int,
    onToggleGrid: () -> Unit,
    isGrid: Boolean
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = albumState.albums.find {it.id == albumIdInt}?.title ?: "Loading...",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 24.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (username != null) {
                Text(
                    text = username,
                    fontSize = 16.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onToggleGrid() }) {
                if (!isGrid) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change the Grid"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Change the Grid"
                    )
                }
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PhotoContentPreview() {
    val samplePhotos = List(10) { index ->
        Photo(
            id = index,
            albumId = 1,
            title = "Sample Photo $index",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/150/92c952"
        )
    }
    val sampleAlbumState = AlbumState(
        photos = samplePhotos,
        isLoadingPhotos = false
    )
    PhotoContent(
        albumState = sampleAlbumState,
        username = "Sample User",
        albumIdInt = 1
    )
}
