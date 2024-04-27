package com.example.afinal.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(onBackClick: () -> Unit, onTimerValueChanged: (Int) -> Unit) {
    var initialTimerValue by remember { mutableStateOf(60) }
    var enableNotifications by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "Settings")

        Spacer(modifier = Modifier.height(16.dp))

        // Input field for initial timer value
        OutlinedTextField(
            value = initialTimerValue.toString(),
            onValueChange = { value ->
                initialTimerValue = value.toIntOrNull() ?: 0
            },
            label = { Text("Initial Timer Value") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox for enabling notifications
        Checkbox(
            checked = enableNotifications,
            onCheckedChange = { checked ->
                enableNotifications = checked
            }
        )
        Text(text = "Enable Notifications")

        Spacer(modifier = Modifier.height(32.dp))

        // Button to save settings and go back
        Button(onClick = {
            onTimerValueChanged(initialTimerValue)
            onBackClick()
        }) {
            Text("Save & Back")
        }
    }
}