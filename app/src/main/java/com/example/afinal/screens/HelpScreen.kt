package com.example.afinal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.afinal.R   // Assuming R is the resource class for your project

@Composable
fun HelpScreen(onBackClick: () -> Unit) {
    Column {
        // Display the image
        Image(
            painter = painterResource(id = R.drawable.Timer),
            contentDescription = "Timer Image",
            modifier = Modifier.size(200.dp)
        )

        // Back button
        TextButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}



