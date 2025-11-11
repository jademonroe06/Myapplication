package es.fpsumma.dam2.myapplication.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import es.fpsumma.dam2.myapplication.ui.screens.editprofile.UserProfile

// IMPORTANTE: Asegúrate de que este data class esté accesible o usa el que definiste en EditProfileScreen
data class UserProfile(
    val fullName: String,
    val profession: String,
    val email: String,
    val phone: String,
    val location: String,
    val academicFormation: String
)

class UserProfileViewModel : ViewModel() {

    // 1. EL ESTADO MUTABLE (Single Source of Truth)
    private val _userProfile = mutableStateOf(
        _root_ide_package_.es.fpsumma.dam2.myapplication.ui.screens.editprofile.UserProfile(
            fullName = "Andrea Fernández García", // Datos iniciales
            profession = "Desarrolladora Android",
            email = "andrea.fg@example.com",
            phone = "+34 600 123 456",
            location = "Madrid, España",
            academicFormation = "DAM2 - Desarrollo de Aplicaciones Multiplataforma"
        )
    )
    // 2. EL ESTADO INMUTABLE (La vista solo lo lee)
    val userProfile: MutableState<UserProfile> = _userProfile

    // 3. LA LÓGICA DE GUARDADO (Actualiza el estado)
    fun saveProfile(updatedUser: es.fpsumma.dam2.myapplication.ui.screens.editprofile.UserProfile) {
        // Al actualizar _userProfile.value, TODAS las pantallas que lo observan se recomponen
        _userProfile.value = updatedUser
        println("✅ USUARIO ACTUALIZADO EN EL VIEWMODEL")
        // Aquí iría la lógica para guardar en una base de datos o API.
    }
}