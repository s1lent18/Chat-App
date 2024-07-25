package com.example.chattingapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chattingapp.R
import com.example.chattingapp.data.Screens
import com.example.chattingapp.viewmodel.ChatAppViewModel

@Composable
fun AddHeight(size: Dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun AddWidth(size: Dp) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun StartPage(
    navController: NavController,
    chatAppViewModel: ChatAppViewModel
) {
    Surface {
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
            Icon(painter = painterResource(R.drawable.chitchatlogo),
                contentDescription = "",
                tint = Color.White,
                )
            Button(
                onClick = {
                    navController.navigate(route = Screens.Login.route)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFDC500),
                    contentColor = Color(0xFF121212)
                ),
                modifier = Modifier.fillMaxWidth(fraction = 0.5f)
            ) {
                Text("Login", fontWeight = FontWeight.Bold, fontSize = 17.sp)
            }
            AddHeight(20.dp)
            Button(
                onClick = {
                    navController.navigate(route = Screens.Signup.route)
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFFDC500)
                ),
                modifier = Modifier.fillMaxWidth(fraction = 0.5f),
                border = BorderStroke(1.dp, color = Color(0xFFFDC500))
            ) {
                Text("SignUp", fontWeight = FontWeight.Bold, fontSize = 17.sp)
            }
        }
    }
}