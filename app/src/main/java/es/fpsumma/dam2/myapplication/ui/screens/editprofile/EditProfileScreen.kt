package es.fpsumma.dam2.myapplication.ui.screens.editprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import es.fpsumma.dam2.myapplication.ui.screens.viewmodel.UserProfileViewModel
import androidx.compose.runtime.State
import es.fpsumma.dam2.myapplication.ui.screens.editprofile.UserProfile

// --- Composable Principal (EditProfileScreen) ---

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    navController: NavController,
    viewModel: UserProfileViewModel = viewModel()
){
    // Obtener los datos iniciales del ViewModel
    val initialUser = viewModel.userProfile.value
    // Estados mutables para los campos de edición
    var fullName by remember { mutableStateOf(initialUser.fullName) }
    var profession by remember { mutableStateOf(initialUser.profession) }
    var email by remember { mutableStateOf(initialUser.email) }
    var phone by remember { mutableStateOf(initialUser.phone) }
    var location by remember { mutableStateOf(initialUser.location) }
    var academicFormation by remember { mutableStateOf(initialUser.academicFormation) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar Perfil") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        // Se quitó el ícono 'automirrored.filled.ArrowBack' que estaba duplicado en los imports
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                },
                //Reemplazo parámetros obsoletos (backgroundColor, contentColor, elevation) por el parámetro 'colors' en M3.
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                    // La elevación se maneja por defecto con colores planos si no se usa `scrollBehavior`
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Campos de Edición
            EditField(label = "Nombre completo", value = fullName) { fullName = it }
            EditField(label = "Profesión", value = profession) { profession = it }
            EditField(label = "Correo electrónico", value = email) { email = it }
            EditField(label = "Teléfono", value = phone) { phone = it }
            EditField(label = "Ubicación", value = location) { location = it }
            EditField(label = "Formación académica", value = academicFormation) { academicFormation = it }

            Spacer(modifier = Modifier.weight(1f)) // Empuja el botón al fondo

            // Botón Guardar cambios
            Button(
                onClick = {
                    val updatedUser = UserProfile(
                        fullName = fullName,
                        profession = profession,
                        email = email,
                        phone = phone,
                        location = location,
                        academicFormation = academicFormation
                    )
                    viewModel.saveProfile(updatedUser)
                    navController.popBackStack() // Navegar hacia atrás después de guardar
                },
                modifier = Modifier
                    .fillMaxWidth(0.6f) // Adaptar a un ancho similar al de la imagen
                    .height(48.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                // Reemplazo parámetros obsoletos (backgroundColor) por el parámetro 'colors' en M3.
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
            ) {
                Text("Guardar cambios", color = Color.White)
            }
        }
    }
}

// --- Composable de Campo de Edición (EditField) ---

@Composable
fun EditField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            label,
            // Uso 'labelSmall' o 'bodySmall' como alternativa común para texto secundario.
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF3F51B5),
                unfocusedBorderColor = Color.LightGray,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}