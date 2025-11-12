package es.fpsumma.dam2.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.fpsumma.dam2.myapplication.ui.screens.editprofile.EditProfileScreen
import es.fpsumma.dam2.myapplication.ui.screens.home.HomeScreen
import es.fpsumma.dam2.myapplication.ui.screens.viewmodel.UserProfileViewModel // Importado
import es.fpsumma.dam2.myapplication.ui.screens.viewprofile.ViewProfileScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    // Instancia compartida
    val userProfileViewModel: UserProfileViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { HomeScreen(navController) }

        // Pasar la instancia compartida
        composable(Routes.PROFILE) {
            ViewProfileScreen(
                navController = navController,
                viewModel = userProfileViewModel
            )
        }

        // Pasar la instancia compartida
        composable(Routes.EDIT_PROFILE){
            EditProfileScreen(
                navController = navController,
                viewModel = userProfileViewModel
            )
        }
    }
}



