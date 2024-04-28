package com.example.afinal.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Text as Text3
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    onHelpClick: () -> Unit
)
    { Column (
        modifier = Modifier.fillMaxWidth().padding(start =16.dp)
    ){
    Spacer(modifier = Modifier.height((16.dp)))
    CenteredBoldText(text = "Productivity App")
    Spacer(modifier = Modifier.height((16.dp)))
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
    }}
}
@Composable
fun CenteredBoldText(text: String) {
    Text3(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}