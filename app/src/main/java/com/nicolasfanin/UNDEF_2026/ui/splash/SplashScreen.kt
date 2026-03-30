package com.nicolasfanin.UNDEF_2026.ui.splash

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicolasfanin.UNDEF_2026.ui.productlist.ProductListActivity

@Composable
fun SplashScreen(modifier: Modifier, text: String) {
    val context = LocalContext.current

    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 20.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .wrapContentSize()
                .border(2.dp, Color.Red)
                .background(Color.Yellow)
                .padding(16.dp),
            color = Color.Blue,
            fontSize = 30.sp
        )

        Button(
            modifier = Modifier
                .wrapContentSize()
                .border(2.dp, Color.Red)
                .background(Color.Yellow)
                .padding(16.dp),
            onClick = { context.startActivity(Intent(context, ProductListActivity::class.java)) },
            enabled = true
        ) {
            Text("INGRESAR")
        }
    }
}


@Preview(showBackground = false, showSystemUi = true)
@Composable
fun SplashScreenPreviewText2() {
    SplashScreen(modifier = Modifier, "Bienvenid@s a mi super aplicacion!")
}