package com.nicolasfanin.UNDEF_2026.ui.productlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.nicolasfanin.UNDEF_2026.ui.theme.UNDEF_2026Theme

class ProductListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Se ejecuto el OnCreate", Toast.LENGTH_SHORT).show()

        setContent {
            UNDEF_2026Theme {
                ProductListScreen()
            }
        }
    }
}