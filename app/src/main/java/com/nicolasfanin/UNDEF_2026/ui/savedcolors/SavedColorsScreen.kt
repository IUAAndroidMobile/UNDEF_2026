package com.nicolasfanin.UNDEF_2026.ui.savedcolors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nicolasfanin.UNDEF_2026.data.database.model.ColorEntity

@Composable
fun SavedColorsScreen(
    viewModel: SavedColorsViewModel = viewModel()
) {

    var nameInput by remember { mutableStateOf("") }
    var hexInput by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Colores Guardados",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Formulario
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it; errorMsg = null },
            label = { Text("Nombre del color") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = hexInput,
            onValueChange = { hexInput = it; errorMsg = null },
            label = { Text("HEX (ej: #FF5733)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        errorMsg?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (nameInput.isBlank() || hexInput.isBlank()) {
                    errorMsg = "Completá ambos campos"
                } else {
                    viewModel.insertColor(
                        ColorEntity(name = nameInput.trim(), hex = hexInput.trim())
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar color")
        }

        Spacer(modifier = Modifier.height(16.dp))

        /**if (colors.isEmpty()) {
        Text(
        text = "No hay colores guardados aún.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        } else {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(colors, key = { it.id }) { color ->
        ColorItem(
        name = color.name,
        hex = color.hex,
        onDelete = { viewModel.deleteColor(color.id) }
        )
        }
        }
        }**/
    }

}