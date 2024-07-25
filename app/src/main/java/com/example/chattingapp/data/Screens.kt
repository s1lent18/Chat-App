package com.example.chattingapp.data

sealed class Screens(val route: String) {
    data object Login: Screens(route = "Login_Screen")
    data object Signup: Screens(route = "Signup_Screen")
    data object Msg: Screens(route = "Msg_Screen/{chatId}") {
        fun createRoute(id: String) = "Msg_Screen/$id"
    }
    data object Profile: Screens(route = "Profile_Screen")
    data object Home: Screens(route = "Home_Screen")
    data object StartPage: Screens(route = "StartPage_Screen")
    data object ChangePassword: Screens(route = "ChangePassword_Screen")
}