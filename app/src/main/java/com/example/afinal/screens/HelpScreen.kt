package com.example.afinal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.afinal.R

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
        Button(onClick = {
            onBackClick()
        }) {
            androidx.compose.material.Text("Back")
        }
    }
}



