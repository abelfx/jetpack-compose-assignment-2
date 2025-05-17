package com.mobileassignment.todolist.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobileassignment.todolist.data.local.entity.TodoEntity

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    suspend fun getTodos(): List<TodoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<TodoEntity>)
}
