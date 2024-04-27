package com.example.afinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.afinal.screens.CalculatorScreen
import com.example.afinal.screens.HelpScreen
import com.example.afinal.screens.NoteTakingScreen
import com.example.afinal.screens.TimerScreen
import com.example.afinal.screens.SettingsScreen
import com.example.afinal.screens.Screen
import com.example.afinal.ui.theme.FinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var currentScreen by remember { mutableStateOf<Screen>(Screen.Calculator) }
                    var initialTimerValue by remember { mutableStateOf(60) }

                    Column(Modifier.fillMaxSize()) {
                        when (currentScreen) {
                            is Screen.Calculator -> CalculatorScreen(
                                onNoteClick = { currentScreen = Screen.Notes },
                                onCalendarClick = { currentScreen = Screen.Calendar },
                                onTimerClick = { currentScreen = Screen.Timer },
                                onSettingsClick = { currentScreen = Screen.Settings },
                                onHelpClick = { currentScreen = Screen.Help }
                            )
                            is Screen.Notes -> NoteTakingScreen(onBackClick = { currentScreen = Screen.Calculator })
                            Screen.Calendar -> TODO()
                            Screen.Timer -> TimerScreen(
                                initialTimerValue = initialTimerValue,
                                onBackClick = { currentScreen = Screen.Calculator }
                            )
                            Screen.Settings -> SettingsScreen(
                                onBackClick = { currentScreen = Screen.Calculator },
                                onTimerValueChanged = { value ->
                                    initialTimerValue = value
                                }
                            )

                            Screen.Help -> HelpScreen(
                                onBackClick = { currentScreen = Screen.Calculator }
                            )
                        }
                    }
                }
            }
        }
    }
}