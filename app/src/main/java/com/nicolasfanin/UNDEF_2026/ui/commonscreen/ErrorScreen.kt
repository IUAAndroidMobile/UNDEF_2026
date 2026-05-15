package com.nicolasfanin.UNDEF_2026.ui.commonscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ErrorScreen(message: String, onRetry: () -> Unit) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column() {
                Text(message)
                Button(onClick = { onRetry() }) {
                    Text(text = "Reintentar")
                }
            }
        }
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(message = "Error", onRetry = {})
}


