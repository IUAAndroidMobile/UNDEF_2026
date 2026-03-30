package com.nicolasfanin.UNDEF_2026.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.nicolasfanin.UNDEF_2026.ui.splash.SplashScreen
import com.nicolasfanin.UNDEF_2026.ui.theme.UNDEF_2026Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cargar la UI / Layout
        //enableEdgeToEdge()
        setContent {
            UNDEF_2026Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Text("Top Bar")
                    },
                    bottomBar = {

                    },
                    floatingActionButton = {
                        Button(onClick = { }) {
                            Text("+")
                        }
                    }
                ) { innerPadding ->
                    SplashScreen(
                        modifier = Modifier.padding(innerPadding),
                        text = "Bienvenid@ a mi APP!"
                    )

                }
            }
        }
    }
}