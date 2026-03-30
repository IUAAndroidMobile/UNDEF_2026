package com.nicolasfanin.UNDEF_2026.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nicolasfanin.UNDEF_2026.R
import com.nicolasfanin.UNDEF_2026.ui.productlist.ProductListActivity
import com.nicolasfanin.UNDEF_2026.utils.agregarNumeros

@Composable
fun MainScreen(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Acción del botón */ }) {
            Text(stringResource(R.string.pantalla_principal_boton))
        }
        Image(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
                .height(90.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.icon_car),
            contentDescription = null
        )

        val texto = "texto sin ninguna mayuscula"
        val texto2 = "Otro Texto"

        Text(
            text = texto.agregarNumeros()
        )

        Text(
            text = texto2.decapitalize()
        )

        Button(onClick = {
            context.startActivity(Intent(context, ProductListActivity::class.java))
        }) {
            Text("Ir a la segunda pantalla")
        }
    }
}