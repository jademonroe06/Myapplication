package es.fpsumma.dam2.myapplication.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
object ProfileState {
    var nombre    by mutableStateOf("Juan Pérez")
    var profesion by mutableStateOf("Desarrollador Android")
    var correo    by mutableStateOf("juan.perez@email.com")
    var telefono  by mutableStateOf("+34 600 123 456")
    var ubicacion by mutableStateOf("Madrid, España")
    var formacion by mutableStateOf("Grado en Ingeniería Informática")

}