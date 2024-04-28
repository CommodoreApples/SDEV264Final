package com.example.afinal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.afinal.R

@Composable
fun HelpScreen(onBackClick: () -> Unit,
               buttonColor: Color
) {
    Image(
        painter = painterResource(id = R.drawable.timer), // Use the resource ID directly
        contentDescription = "Timer Image",
        modifier = Modifier.size(300.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Back button
    Button(
        onClick = { onBackClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor) // Set button color
    ) {
        androidx.compose.material.Text("Back")
    }
}