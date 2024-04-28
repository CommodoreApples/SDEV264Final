package com.example.afinal.screens

sealed class Screen {
    data object Calculator : Screen()
    data object Notes : Screen()
    data object Calendar : Screen()
    data object Timer : Screen()
    data object Settings : Screen()
    data object Help : Screen()
    data object Main : Screen()
}