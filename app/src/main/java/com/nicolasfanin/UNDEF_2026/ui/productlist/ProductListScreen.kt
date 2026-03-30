package com.nicolasfanin.UNDEF_2026.ui.productlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicolasfanin.UNDEF_2026.R

@Composable
fun ProductListScreen() {
    LazyColumn(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        items(100) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        println("Item $it")
                    }
            ) {
                Text(
                    modifier = Modifier
                        .border(1.dp, Color.Blue)
                        .padding(16.dp),
                    text = "Item $it"
                )
                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.icon_car),
                    contentDescription = null
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview() {
    ProductListScreen()
}