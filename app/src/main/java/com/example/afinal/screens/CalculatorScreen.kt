package com.example.afinal.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(
    onNoteClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onTimerClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit) {
    val displayState = remember { mutableStateOf("0") }

    fun handleButtonClick(value: String) {
        when (value) {
            "C" -> displayState.value = "0"
            "=" -> {
                // Calculate the result
                try {
                    val result = calculateResult(displayState.value)
                    displayState.value = result.toString()
                } catch (e: IllegalArgumentException) {
                    displayState.value = "Error"
                } catch (e: ArithmeticException) {
                    displayState.value = "Error"
                }
            }
            else -> {
                if (displayState.value == "0" && value != "0") {
                    displayState.value = value
                } else {
                    displayState.value += value
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Calculator",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Display
        Text(
            text = displayState.value,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Rows of buttons
        Row(modifier = Modifier.fillMaxWidth()) {
            CalculatorButton(text = "1", onClick = ::handleButtonClick)
            CalculatorButton(text = "2", onClick = ::handleButtonClick)
            CalculatorButton(text = "3", onClick = ::handleButtonClick)
            CalculatorButton(text = "+", onClick = ::handleButtonClick)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            CalculatorButton(text = "4", onClick = ::handleButtonClick)
            CalculatorButton(text = "5", onClick = ::handleButtonClick)
            CalculatorButton(text = "6", onClick = ::handleButtonClick)
            CalculatorButton(text = "-", onClick = ::handleButtonClick)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            CalculatorButton(text = "7", onClick = ::handleButtonClick)
            CalculatorButton(text = "8", onClick = ::handleButtonClick)
            CalculatorButton(text = "9", onClick = ::handleButtonClick)
            CalculatorButton(text = "*", onClick = ::handleButtonClick)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            CalculatorButton(text = "C", onClick = ::handleButtonClick)
            CalculatorButton(text = "0", onClick = ::handleButtonClick)
            CalculatorButton(text = "=", onClick = ::handleButtonClick)
            CalculatorButton(text = "/", onClick = ::handleButtonClick)
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onNoteClick) {
            Text("Take Notes")
        }
        //Spacer(modifier = Modifier.height(16.dp))
        //TextButton(onClick = onCalendarClick) {
        //    Text("See Calendar")
        //}
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onTimerClick) {
            Text("Set Timer")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onSettingsClick) {
            Text("Settings")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onHelpClick) {
            Text("Help")
        }
    }
}

@Composable
fun CalculatorButton(text: String, onClick: (String) -> Unit) {
    TextButton(
        onClick = { onClick(text) },
        modifier = Modifier
            .height(64.dp)
            .width(64.dp)
    ) {
        Text(text = text)
    }
}

fun calculateResult(expression: String): Int {
    // Basic calculation logic, you can extend it to support more operations
    val sanitizedExpression = expression.replace(Regex("[^\\d+\\-*/]"), "")
    if (sanitizedExpression.isEmpty()) {
        return 0 // Return 0 if the expression is empty
    }
    return try {
        eval(sanitizedExpression)
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("Invalid expression")
    } catch (e: ArithmeticException) {
        throw ArithmeticException("Division by zero")
    }
}

// This function evaluates a mathematical expression and returns the result
fun eval(expression: String): Int {
    val operators = expression.filter { it in "+-*/" }
    val values = expression.split(Regex("[+\\-*/]")).mapNotNull { it.toIntOrNull() }

    // Ensure both values and operators have the same size
    require(values.size == operators.length + 1) { "Invalid expression" }

    var result = values[0]
    for (i in operators.indices) {
        val operator = operators[i]
        val value = values[i + 1]
        result = when (operator) {
            '+' -> result + value
            '-' -> result - value
            '*' -> result * value
            '/' -> result / value
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }
    return result
}