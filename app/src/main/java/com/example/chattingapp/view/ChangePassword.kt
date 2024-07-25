package com.example.chattingapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview
@Composable
fun ChangePassword(
    navController: NavController
) {
    Surface {
        val (email, setemail) = remember { mutableStateOf("") }
        val gradient = Brush.linearGradient(
            colors = listOf(
                Color(0xFF031111),
                Color(0xFF093a3e),
                Color(0xFF004346),
                Color(0xFF004346),
                Color(0xFF031111)
            ),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(fraction = 0.8f)
            ) {
                Text("Change\nPassword", color = Color(0xFFFDC500), fontSize = 25.sp, fontWeight = FontWeight.Bold)
                AddHeight(100.dp)
                TextField(
                    value = email,
                    label = { Text("Email:", fontSize = 12.sp) },
                    onValueChange = setemail,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedLabelColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedPlaceholderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        focusedIndicatorColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                AddHeight(300.dp)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFDC500),
                            contentColor = Color(0xFF121212)
                        ),
                        modifier = Modifier.fillMaxWidth(fraction = 0.5f)
                    ) {
                        Text("SEND", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }
                }
                AddHeight(50.dp)
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Don't have an Account?", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    AddWidth(6.dp)
                    Text("Signup", color = Color(0xFFFDC500), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}