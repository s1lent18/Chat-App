package com.example.chattingapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chattingapp.data.Screens

@Composable
fun Signup(navController: NavController) {
    Surface {
        val (name, setname) = remember { mutableStateOf("") }
        val (email, setemail) = remember { mutableStateOf("") }
        val (password, setpassword) = remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        var selectedCountry by remember { mutableStateOf("US") }
        var selectedCode by remember { mutableStateOf("+1") }
        val (phonenumber, setphonenumber) = remember { mutableStateOf("") }
        val gradient = Brush.linearGradient(
            colors = listOf(
                Color(0xFF031111),
                Color(0xFF093a3e),
                Color(0xFF004346),
                Color(0xFF004346),
                Color(0xFF031111)
            ),
        )
        val countries = listOf(
            Country("US", "+1"),
            Country("IN", "+91"),
            Country("PK", "+92"),
            Country("IR", "+98"),
            Country("IQ", "+991"),
            Country("LO", "+32"),
            Country("PO", "+99"),
            Country("JP", "+43")
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
                Text("Create",  color = Color(0xFFFDC500), fontSize = 25.sp, fontWeight = FontWeight.Bold)
                AddHeight(10.dp)
                Text("New Account",  color = Color(0xFFFDC500), fontSize = 25.sp, fontWeight = FontWeight.Bold)
                AddHeight(80.dp)
                TextField(
                    value = name,
                    label = { Text("Username:", fontSize = 12.sp) },
                    onValueChange = setname,
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
                    modifier = Modifier.fillMaxWidth()
                )
                AddHeight(20.dp)
                Box(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = phonenumber,
                        onValueChange = setphonenumber,
                        modifier = Modifier.fillMaxWidth().padding(start = 80.dp),
                        placeholder = { Text("+1 (555) 000-000", color = Color.White, fontSize = 12.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
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
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 8.dp)
                            .background(Color.Transparent)
                            .height(56.dp)
                    ) {
                        OutlinedButton(
                            onClick = { expanded = true },
                            modifier = Modifier
                                .fillMaxHeight(),
                            contentPadding = PaddingValues(0.dp),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = selectedCode, fontSize = 14.sp, color = Color.White)
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.background(Color.Transparent).height(300.dp),
                        ) {
                            countries.forEach {country ->
                                DropdownMenuItem(
                                    modifier = Modifier.width(70.dp).background(Color.Transparent),
                                    text = {
                                        Text(country.dialcode, fontSize = 14.sp)
                                    },
                                    onClick = {
                                        selectedCountry = country.name
                                        selectedCode = country.dialcode
                                        expanded = false
                                    },
                                )
                            }
                        }
                    }
                }
                AddHeight(70.dp)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            navController.navigate(route = Screens.Signup.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFDC500),
                            contentColor = Color(0xFF121212)
                        ),
                        modifier = Modifier.fillMaxWidth(fraction = 0.5f)
                    ) {
                        Text("SignUp", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }
                }
                AddHeight(70.dp)
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Have an Account?", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    AddWidth(6.dp)
                    Text("Login", color = Color(0xFFFDC500), fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.clickable {
                        navController.navigate(route = Screens.Login.route)
                    })
                }
            }
        }
    }
}

data class Country(val name: String, val dialcode: String)