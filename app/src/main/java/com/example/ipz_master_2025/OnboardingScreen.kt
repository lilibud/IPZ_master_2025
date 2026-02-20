package com.example.ipz_master_2025

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingScreen(onContinue: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Ласкаво просимо 👋")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Це наш чат-додаток")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onContinue) {
            Text("Продовжити")
        }
    }
}}