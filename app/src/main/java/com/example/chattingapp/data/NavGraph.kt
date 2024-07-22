package com.example.chattingapp.data

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.chattingapp.view.Home
import com.example.chattingapp.view.Login
import com.example.chattingapp.view.Profile
import com.example.chattingapp.view.Signup
import com.example.chattingapp.viewmodel.ChatAppViewModel

@Composable
fun NavGraph(
    navController: NavHostController
) {
    var vm = hiltViewModel<ChatAppViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ) {
        this.composable (route = Screens.Login.route) {
            Login(navController = navController)
        }

        this.composable(route = Screens.Signup.route) {
            Signup(navController = navController )
        }

        this.composable(route = Screens.Profile.route) {
            Profile(navController = navController)
        }

        this.composable(route = Screens.Home.route) {
            Home(navController = navController)
        }
    }
}