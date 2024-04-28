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
import com.example.afinal.screens.MainMenu
import com.example.afinal.screens.NoteTakingScreen
import com.example.afinal.screens.Screen
import com.example.afinal.screens.SettingsScreen
import com.example.afinal.screens.TimerScreen
import com.example.afinal.screens.colorOptions
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
                    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }
                    var initialTimerValue by remember { mutableStateOf(60) }
                    var selectedColorIndex by remember { mutableStateOf(0) } // Track selected color index

                    Column(Modifier.fillMaxSize()) {
                        when (currentScreen) {
                            Screen.Main -> MainMenu(
                                onCalculatorClick = { currentScreen = Screen.Calculator },
                                onNoteClick = { currentScreen = Screen.Notes },
                                onCalendarClick = { currentScreen = Screen.Calendar },
                                onTimerClick = { currentScreen = Screen.Timer },
                                onSettingsClick = { currentScreen = Screen.Settings },
                                onHelpClick = { currentScreen = Screen.Help },
                                buttonColor = colorOptions[selectedColorIndex] // Pass selected color
                            )
                            Screen.Calculator -> CalculatorScreen(
                                onBackClick = { currentScreen = Screen.Main},
                                buttonColor = colorOptions[selectedColorIndex]
                            )
                            Screen.Notes -> NoteTakingScreen(
                                onBackClick = { currentScreen = Screen.Main },
                                buttonColor = colorOptions[selectedColorIndex]
                                )
                            Screen.Calendar -> TODO()
                            Screen.Timer -> TimerScreen(
                                initialTimerValue = initialTimerValue,
                                onBackClick = { currentScreen = Screen.Main},
                                buttonColor = colorOptions[selectedColorIndex]
                            )
                            Screen.Settings -> SettingsScreen(
                                onBackClick = { currentScreen = Screen.Main },
                                onTimerValueChanged = { value -> initialTimerValue = value },
                                selectedColorIndex = selectedColorIndex,
                                onColorSelected = { index -> selectedColorIndex = index }
                            )

                            Screen.Help -> HelpScreen(
                                onBackClick = { currentScreen = Screen.Main},
                                buttonColor = colorOptions[selectedColorIndex]
                            )
                        }
                    }
                }
            }
        }
    }
}