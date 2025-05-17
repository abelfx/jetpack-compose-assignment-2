package com.mobileassignment.todolist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobileassignment.todolist.data.local.dao.TodoDao
import com.mobileassignment.todolist.data.local.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
