package es.fpsumma.dam2.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.fpsumma.dam2.myapplication.ui.screens.editprofile.EditProfileScreen
import es.fpsumma.dam2.myapplication.ui.screens.editprofile.UserProfile
import es.fpsumma.dam2.myapplication.ui.screens.home.HomeScreen
import es.fpsumma.dam2.myapplication.ui.screens.viewprofile.ViewProfileScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.PROFILE) { ViewProfileScreen(navController) }
        composable(Routes.EDIT_PROFILE){ EditProfileScreen(navController = navController) }
    }
}



