package com.nicolasfanin.UNDEF_2026.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nicolasfanin.UNDEF_2026.NavigationApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cargar la UI / Layout
        //enableEdgeToEdge()
        setContent {
            NavigationApp()
        }
    }
}