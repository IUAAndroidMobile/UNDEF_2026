package com.nicolasfanin.UNDEF_2026.ui.userpreferences

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserPreferencesScreen(
    viewModel: UserPreferencesViewModel = viewModel()
) {
    val nombreUsuarioFlow by viewModel.nombreUsuarioFlow.collectAsState()

    val notificacionesFlow by viewModel.notificacionesFlow.collectAsState()

    var userNameInput by remember { mutableStateOf(nombreUsuarioFlow) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ejemplo DataStore",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Los valores persistentes son: Nombre Usuario: ${nombreUsuarioFlow}, y: Notificaciones: ${notificacionesFlow}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        OutlinedTextField(
            value = userNameInput,
            onValueChange = { userNameInput = it },
            label = { Text("Nuevo nombre") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.saveNombreUsuario(userNameInput)
                    userNameInput = ""
                }
            )
        )

        Button(onClick = {
            viewModel.saveNombreUsuario(userNameInput)
            userNameInput = ""
        }) {
            Text("Guardar")
        }

        Switch(
            checked = notificacionesFlow,
            onCheckedChange = { viewModel.saveNotificaciones(!notificacionesFlow) }
        )



    }

}
