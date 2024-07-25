package com.example.chattingapp.data

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.chattingapp.view.ChangePassword
import com.example.chattingapp.view.Home
import com.example.chattingapp.view.Login
import com.example.chattingapp.view.Profile
import com.example.chattingapp.view.Signup
import com.example.chattingapp.view.StartPage
import com.example.chattingapp.viewmodel.ChatAppViewModel
import com.example.chattingapp.viewmodel.DialCodeViewModel

@Composable
fun NavGraph(
    navController: NavHostController
) {
    var vm = hiltViewModel<ChatAppViewModel>()
    val owner = LocalViewModelStoreOwner.current
    val codeviewmodel = ViewModelProvider(owner!!)[DialCodeViewModel::class.java]

    NavHost(
        navController = navController,
        startDestination = Screens.StartPage.route
    ) {
        this.composable (route = Screens.Login.route) {
            Login(navController = navController)
        }

        this.composable(route = Screens.Signup.route) {
            Signup(navController = navController)
        }

        this.composable(route = Screens.Profile.route) {
            Profile(navController = navController)
        }

        this.composable(route = Screens.Home.route) {
            Home(navController = navController)
        }

        this.composable(route = Screens.StartPage.route) {
            StartPage(navController = navController, chatAppViewModel =  vm)
        }

        this.composable(route = Screens.ChangePassword.route) {
            ChangePassword(navController = navController)
        }
    }
}