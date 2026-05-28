package com.nicolasfanin.UNDEF_2026

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nicolasfanin.UNDEF_2026.ui.productlist.ui.ProductListScreen
import com.nicolasfanin.UNDEF_2026.ui.register.RegisterUserScreen
import com.nicolasfanin.UNDEF_2026.ui.splash.SplashScreen
import com.nicolasfanin.UNDEF_2026.ui.userpreferences.UserPreferencesScreen

@Composable
fun NavigationApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SPLASHSCREEN) {
        composable(SPLASHSCREEN) {
            SplashScreen(
                text = "Bienvenid@s a mi super aplicacion!",
                onInitButtonClick = { navController.navigate(PRODUCTLIST) },
                onCreateAccountClick = { navController.navigate(REGISTERUSER) },
                onUserPreferencesClick = { navController.navigate(USER_PREFERENCES) })
        }
        composable(PRODUCTLIST) {
            ProductListScreen()
        }
        composable(REGISTERUSER) {
            RegisterUserScreen()
        }
        composable(USER_PREFERENCES) {
            UserPreferencesScreen()
        }
    }
}


const val SPLASHSCREEN = "splash_screen"
const val PRODUCTLIST = "product_list"
const val REGISTERUSER = "register_user"
const val USER_PREFERENCES = "user_preferences"


