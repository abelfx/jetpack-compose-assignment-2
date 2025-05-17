package com.mobileassignment.todolist.ui.screen.todoDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobileassignment.todolist.data.local.entity.TodoEntity
import com.mobileassignment.todolist.data.remote.AppModule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoDetailScreen(todoId: Int, navController: NavController) {
    var todo by remember { mutableStateOf<TodoEntity?>(null) }

    LaunchedEffect(todoId) {
        todo = AppModule.repository.getTodoById(todoId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Todo Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        todo?.let {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 80.dp)) {
                Text(text = "ID: ${it.id}")
                Spacer(Modifier.height(8.dp))
                Text(text = "Title: ${it.title}")
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Status: ${if (it.completed) "Completed ✅" else "Incomplete ❌"}"
                )
            }
        } ?: Text(
            text = "Loading...",
            modifier = Modifier.padding(padding).padding(16.dp)
        )
    }
}
