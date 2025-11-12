package es.fpsumma.dam2.myapplication.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

// Importar solo los necesarios
// import androidx.compose.runtime.State // Esto ya no es necesario si usas MutableState

// CLASE DE DATOS ÚNICA
data class UserProfile(
    val fullName: String,
    val profession: String,
    val email: String,
    val phone: String,
    val location: String,
    val academicFormation: String
)

class UserProfileViewModel : ViewModel() {

    // ESTADO MUTABLE
    private val _userProfile = mutableStateOf(
        UserProfile(
            fullName = "Andrea Fernández García",
            profession = "Desarrolladora Android",
            email = "andrea.fg@example.com",
            phone = "+34 600 123 456",
            location = "Madrid, España",
            academicFormation = "DAM2 - Desarrollo de Aplicaciones Multiplataforma"
        )
    )
    // ESTADO INMUTABLE para que las vistas SOLO lean (usando 'by')
    val userProfile: MutableState<UserProfile> = _userProfile

    // LÓGICA DE GUARDADO
    fun saveProfile(updatedUser: UserProfile) {
        // Al actualizar _userProfile.value, TODAS las pantallas que lo observan se recomponen
        _userProfile.value = updatedUser
        println("✅ USUARIO ACTUALIZADO EN EL VIEWMODEL")
    }
}