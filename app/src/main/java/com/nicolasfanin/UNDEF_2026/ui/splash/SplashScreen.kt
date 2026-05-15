package com.nicolasfanin.UNDEF_2026.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(
    text: String,
    onInitButtonClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {}
) {

    val context = LocalContext.current
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 20.dp)
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
            onClick = { onInitButtonClick() },
            enabled = true
        ) {
            Text("INGRESAR")
        }

        Button(
            modifier = Modifier
                .wrapContentSize()
                .border(2.dp, Color.Red)
                .background(Color.Yellow)
                .padding(16.dp),
            onClick = { onCreateAccountClick() },
            enabled = true
        ) {
            Text("Crear Cuenta")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreviewText2() {
    SplashScreen("Bienvenid@s a mi super aplicacion!")
}