package com.mobileassignment.todolist

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mobileassignment.todolist.data.remote.AppModule
import com.mobileassignment.todolist.ui.navigation.NavGraph
import com.mobileassignment.todolist.ui.theme.JetpackcomposeassignmentTheme

class TodoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppModule.initialize(this)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeassignmentTheme {
                NavGraph()
            }
        }
    }
}
