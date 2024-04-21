package com.android4you.multimodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android4you.navigation.NavigationItem

@Composable
fun AppScreen(navigateTo: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateTo("home_screen")}) {
            Text(text = "Navigate To Home")
        }

        Button(onClick = {
            navigateTo(
                NavigationItem.FeatureProfile.withArgs(
                    "Profile info"
                )
            )
           // navigateTo("profile_screen")
        }) {
            Text(text = "Navigate To Profile")
        }
    }
}