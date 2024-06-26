package com.example.afinal.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimerScreen(
    initialTimerValue: Int,
    onBackClick: () -> Unit,
    buttonColor: Color
) {
    var timeRemaining by remember { mutableStateOf(initialTimerValue) }
    var timerRunning by remember { mutableStateOf(false) }
    var coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "Timer: $timeRemaining seconds")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (!timerRunning) {
                timerRunning = true
                coroutineScope.launch {
                    startTimer(timeRemaining) {
                        if (it > 0) {
                            timeRemaining = it
                        } else {
                            timerRunning = false
                        }
                    }
                }
            }
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
            ) {
            Text(text = "Start")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            timerRunning = false
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
            ) {
            Text(text = "Pause")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            timeRemaining = initialTimerValue
            timerRunning = false
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
            ) {
            Text(text = "Reset")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onBackClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
        ) {
            androidx.compose.material.Text("Back")
        }
    }
}

suspend fun startTimer(initialTime: Int, onTick: (Int) -> Unit) {
    var timeRemaining = initialTime
    while (timeRemaining > 0) {
        delay(1000)
        timeRemaining--
        onTick(timeRemaining)
    }
}