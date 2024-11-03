package kz.singularity.jetpackcomposemost.presentation.albums

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kz.singularity.jetpackcomposemost.presentation.ui.components.AlbumCard

@Composable
fun PhotoContent(state: AlbumState, username: String?, albumIdInt: Int) {
    var isGrid by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {
            Text(
                text = "Album Name",
                style = MaterialTheme.typography.headlineMedium
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (username != null) {
                    Text(
                        text = username,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                IconButton(onClick = { isGrid = !isGrid }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change the Grid"
                    )
                }
            }
        }

        val selectedAlbumId = albumIdInt
        val photos = state.photos.filter { it.albumId == selectedAlbumId }

        if (isGrid) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize() // Ensure LazyVerticalGrid fills the remaining space
            ) {
                items(photos) { photo ->
                    AlbumCard(
                        albumName = photo.title,
                        username = "",
                        ratio = 4 / 4f
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize() // Ensure LazyColumn fills the remaining space
            ) {
                items(photos) { photo ->
                    AlbumCard(
                        albumName = photo.title,
                        username = "",
                        ratio = 16 / 9f
                    )
                }
            }
        }
    }
}

