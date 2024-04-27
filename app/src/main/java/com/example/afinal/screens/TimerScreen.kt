package com.example.afinal.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimerScreen(
    initialTimerValue: Int,
    onBackClick: () -> Unit
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
        }) {
            Text(text = "Start")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            timerRunning = false
        }) {
            Text(text = "Pause")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            timeRemaining = initialTimerValue
            timerRunning = false
        }) {
            Text(text = "Reset")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onBackClick) {
            Text(text = "Back")
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