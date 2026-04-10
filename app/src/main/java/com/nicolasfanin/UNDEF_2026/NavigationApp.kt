package com.nicolasfanin.UNDEF_2026

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nicolasfanin.UNDEF_2026.presentacion.productlist.ProductListScreen
import com.nicolasfanin.UNDEF_2026.presentacion.register.RegisterUserScreen
import com.nicolasfanin.UNDEF_2026.presentacion.splash.SplashScreen

@Composable
fun NavigationApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SPLASHSCREEN) {
        composable(SPLASHSCREEN) {
            SplashScreen(
                text = "Bienvenid@s a mi super aplicacion!",
                onInitButtonClick = { navController.navigate(PRODUCTLIST) },
                onCreateAccountClick = { navController.navigate(REGISTERUSER) })
        }
        composable(PRODUCTLIST) {
            ProductListScreen()
        }
        composable(REGISTERUSER) {
            RegisterUserScreen()
        }
    }
}


const val SPLASHSCREEN = "splash_screen"
const val PRODUCTLIST = "product_list"
const val REGISTERUSER = "register_user"


