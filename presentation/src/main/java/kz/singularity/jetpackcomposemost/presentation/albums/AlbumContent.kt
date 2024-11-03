package kz.singularity.jetpackcomposemost.presentation.albums
import LoadingState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kz.singularity.jetpackcomposemost.domain.model.Album
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.presentation.ui.components.AlbumCard

@Composable
fun AlbumContent(state: AlbumState, navController: NavHostController, users: List<User>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        if (state.isLoadingAlbums) {
            LoadingState()
        } else {
            AlbumList(state.albums, navController, users)
        }
    }
}

@Composable
fun AlbumList(
    albums: List<Album>,
    navController: NavController,
    users: List<User>,
    ) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(albums) { album ->
            AlbumCard(
                albumName = album.title,
                username = users.find { it.id == album.userId }?.username ?: "",
                ratio = 16 / 9f,
                modifier = Modifier.clickable {
                    navController.navigate("photos/${album.id}" +
                            "/${users.find { it.id == album.userId }?.username ?: ""}")
                }
            )
        }
    }
}
