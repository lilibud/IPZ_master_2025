    package com.example.ipz_master_2025

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.material3.Button
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.unit.dp

    data class Message(val text: String, val isMe: Boolean)

    @Composable
    fun ChatScreen() {
        var messageText by remember { mutableStateOf("") }
        var messages by remember {
            mutableStateOf(
                listOf(
                    Message("Привіт!", false),
                    Message("Привіт! 👋", true)
                )
            )
        }

        Column(modifier = Modifier.fillMaxSize()) {

            LazyColumn(
                modifier = Modifier.weight(1f).padding(8.dp)
            ) {
                items(messages) { msg ->
                    MessageItem(msg)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = messageText,
                    onValueChange = { messageText = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Введіть повідомлення") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (messageText.isNotBlank()) {
                            messages = messages + Message(messageText, true)
                            messageText = ""
                        }
                    },
                    enabled = messageText.isNotBlank()
                ) {
                    Text("Send")
                }
            }
        }
    }

    @Composable
    fun MessageItem(message: Message) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (message.isMe) Arrangement.End else Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(
                        if (message.isMe) Color.Green else Color.LightGray
                    )
                    .padding(8.dp)
            ) {
                Text(message.text)
            }
        }
    }

