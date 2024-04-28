package com.example.afinal.screens

import androidx.compose.material.Button
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainMenu(
    onCalculatorClick: () -> Unit,
    onNoteClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onTimerClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    Button(onClick = {
        onCalculatorClick()
    }) {
        Text("Calculator")
    }
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = {
        onNoteClick()
    }) {
        Text("Take notes")
    }
    //Spacer(modifier = Modifier.height(16.dp))
    //TextButton(onClick = onCalendarClick) {
    //    Text("See Calendar")
    //}
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = {
        onTimerClick()
    }) {
        Text("Timer")
    }
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = {
        onSettingsClick()
    }) {
        Text("Settings")
    }
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = {
        onHelpClick()
    }) {
        Text("Help")
    }
}