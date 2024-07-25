package com.example.chattingapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chattingapp.R
import com.example.chattingapp.data.Screens

@Composable
fun Login(navController: NavController) {
    Surface {
        val (email, setemail) = remember { mutableStateOf("") }
        val (password, setpassword) = remember { mutableStateOf("") }
        var passwordvisibility by remember { mutableStateOf(false) }
        val icon = if (passwordvisibility) painterResource(R.drawable.vision) else painterResource(R.drawable.eyelock)
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
                AddHeight(50.dp)
                Text("Hi!", color = Color(0xFFFDC500), fontSize = 25.sp, fontWeight = FontWeight.Bold)
                AddHeight(10.dp)
                Text("Welcome Back,", color = Color(0xFFFDC500), fontSize = 25.sp, fontWeight = FontWeight.Bold)
                AddHeight(150.dp)
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
                AddHeight(20.dp)
                TextField(
                    value = password,
                    label = { Text("Password:", fontSize = 12.sp) },
                    onValueChange = setpassword,
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
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        Box(
                            modifier = Modifier.padding(top = 4.dp, end = 8.dp)
                        ) {
                            Row {
                                IconButton(
                                    onClick = {
                                        passwordvisibility = !passwordvisibility
                                    },
                                    modifier = Modifier.size(18.dp)
                                ) {
                                    Icon(painter = icon,
                                        contentDescription = "Icon",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    },
                )
                AddHeight(20.dp)
                Box (
                    Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        "Forgot Password?", fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate(route = Screens.ChangePassword.route)
                        }
                    )
                }
                AddHeight(100.dp)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.Home.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFDC500),
                            contentColor = Color(0xFF121212)
                        ),
                        modifier = Modifier.fillMaxWidth(fraction = 0.5f)
                    ) {
                        Text("Login", fontWeight = FontWeight.Bold, fontSize = 17.sp)
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
                    Text("Signup", color = Color(0xFFFDC500), fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.clickable {
                        navController.navigate(route = Screens.Signup.route)
                    })
                }
            }
        }
    }
}