package com.mobileassignment.todolist.ui.screen.todoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobileassignment.todolist.data.local.entity.TodoEntity
import com.mobileassignment.todolist.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoListViewModel(private val repo: TodoRepository) : ViewModel() {
    private val _todos = MutableStateFlow<List<TodoEntity>>(emptyList())
    val todos: StateFlow<List<TodoEntity>> = _todos

    init {
        viewModelScope.launch {
            repo.getTodos().collect { list ->
                _todos.value = list
            }
        }
    }
}
