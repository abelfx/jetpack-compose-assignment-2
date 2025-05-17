package com.mobileassignment.todolist.data.remote

import android.app.Application
import androidx.room.Room
import com.mobileassignment.todolist.data.local.TodoDatabase
import com.mobileassignment.todolist.data.repository.TodoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    lateinit var repository: TodoRepository
        private set

    fun initialize(app: Application) {
        val db = Room.databaseBuilder(app, TodoDatabase::class.java, "todos.db")
            .fallbackToDestructiveMigration()
            .build()

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val api = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(JsonPlaceholderApi::class.java)

        repository = TodoRepository(api, db.todoDao())
    }
}
