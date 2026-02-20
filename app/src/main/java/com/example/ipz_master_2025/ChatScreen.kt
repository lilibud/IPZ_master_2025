package com.example.ipz_master_2025

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen(
    onOpenSettings: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text("Chat Screen")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onOpenSettings) {
            Text("Open Settings")
        }
    }
}