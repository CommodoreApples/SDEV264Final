package com.example.afinal.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainMenu(
    onCalculatorClick: () -> Unit,
    onNoteClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onTimerClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit,
    buttonColor: Color // Add buttonColor parameter
)
    { Column (
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        CenteredBoldText(text = "Productivity App")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onCalculatorClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
        ) {
            Text("Calculator")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onNoteClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
        ) {
            Text("Take notes")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onTimerClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
        ) {
            Text("Timer")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSettingsClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
        ) {
            Text("Settings")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onHelpClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
        ) {
            Text("Help")
        }
    }
}

@Composable
fun CenteredBoldText(text: String) {
    androidx.compose.material3.Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}