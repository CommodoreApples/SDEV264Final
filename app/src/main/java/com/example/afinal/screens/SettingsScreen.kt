package com.example.afinal.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val LightBlue = Color(0xFFADD8E6)
val LightGreen = Color(0xFF90EE90)
val LightYellow = Color(0xFFFFFFE0)
val LightCyan = Color(0xFFE0FFFF) // Light cyan with alpha value

// Define a list of predefined colors
val colorOptions = listOf(
    Color.LightGray,
    LightBlue,
    LightGreen,
    LightYellow,
    LightCyan
)

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onTimerValueChanged: (Int) -> Unit,
    selectedColorIndex: Int, // Track the index of the selected color
    onColorSelected: (Int) -> Unit // Callback for when a color is selected
) {
    var initialTimerValue by remember { mutableStateOf(60) }
    var enableNotifications by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
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

        // Color picker
        Text("Select Button Color:")
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            colorOptions.forEachIndexed { index, color ->
                Button(
                    onClick = { onColorSelected(index) },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = color)
                ) {
                    if (selectedColorIndex == index) {
                        Text("Selected", color = Color.White)
                    } else {
                        Text("Select", color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Button to save settings and go back
        Button(
            onClick = {
                onTimerValueChanged(initialTimerValue)
                onBackClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorOptions[selectedColorIndex]) // Use selected color for button background color
        ) {
            Text("Save & Back")
        }
    }
}