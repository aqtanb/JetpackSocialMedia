package kz.singularity.jetpackcomposemost.presentation.profile.contents

import kz.singularity.jetpackcomposemost.presentation.ui.components.LoadingState
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.singularity.jetpackcomposemost.domain.model.Todo
import kz.singularity.jetpackcomposemost.presentation.profile.viewmodels.ProfileState
import kz.singularity.presentation.R

@Composable
fun TodoContent(state: ProfileState, userId: Int) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.your_todos),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

      if (state.isLoadingTodos) {
            LoadingState()
        } else {
            val userTodos = state.todos.filter { it.userId == userId }
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(userTodos) { todo ->
                    TodoItem(todo)
                }
            }
        }
}
}

@Composable
fun TodoItem(todo: Todo) {
    var isChecked by remember { mutableStateOf(todo.completed) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(color = Color.White)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = todo.title,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.weight(5f),
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.weight(1f))
            Checkbox(
                checked = isChecked,
                onCheckedChange = { newValue ->
                    isChecked = newValue
                },
                modifier = Modifier.weight(1f),
                colors = CheckboxDefaults.colors(checkedColor = Color.Magenta)
            )
        }
    }
}
