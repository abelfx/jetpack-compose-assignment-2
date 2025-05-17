package com.mobileassignment.todolist.ui.screen.todoList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobileassignment.todolist.data.remote.AppModule


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(navController: NavController) {
    val viewModel = remember { TodoListViewModel(AppModule.repository) }
    val todos by viewModel.todos.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("TODO LIST") }) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(todos.size) { index ->
                val todo = todos[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate("detail/${todo.id}") }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = todo.title, fontSize = 20.sp)
                        Text(text = if (todo.completed) "✅ Completed" else "❌ Not Completed", fontSize = 13.sp )
                    }
                }
            }
        }
    }
}
