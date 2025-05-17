package com.mobileassignment.todolist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mobileassignment.todolist.ui.screen.todoDetail.TodoDetailScreen
import com.mobileassignment.todolist.ui.screen.todoList.TodoListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {
        composable("list") {
            TodoListScreen(navController)
        }
        composable(
            "detail/{todoId}",
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) { backStack ->
            val todoId = backStack.arguments?.getInt("todoId") ?: return@composable
            TodoDetailScreen(todoId, navController)
        }
    }
}
