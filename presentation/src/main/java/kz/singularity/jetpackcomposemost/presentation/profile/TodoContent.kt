package kz.singularity.jetpackcomposemost.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kz.singularity.jetpackcomposemost.domain.model.Todo

@Composable
fun TodoContent(state: ProfileState, userId: Int) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Your Todos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

      if (state.isLoadingTodos) {
            Text("Loading todos...")
        } else {
            val userTodos = state.todos.filter { it.userId == userId }
            LazyColumn {
                items(userTodos) { todo ->
                    TodoItem(todo, onCheckedChange = { isChecked ->
                        println()
                    })
                }
            }
        }
}
}

@Composable
fun TodoItem(todo: Todo, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .height(56.dp)
            .background(Color.White)
            .clickable { /* Handle item click if needed */ }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.completed,
            onCheckedChange = onCheckedChange // Pass the lambda for state change
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = todo.title,
            color = Color.Black
        )
    }
}
