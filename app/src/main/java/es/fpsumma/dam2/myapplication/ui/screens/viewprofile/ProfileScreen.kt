package es.fpsumma.dam2.myapplication.ui.screens.viewprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import es.fpsumma.dam2.myapplication.ui.navigation.Routes
import es.fpsumma.dam2.myapplication.ui.screens.viewmodel.UserProfileViewModel
import es.fpsumma.dam2.myapplication.ui.screens.editprofile.UserProfile

sealed class Screen(val route: String) {
    object EditProfile : Screen("edit_profile_route")
}

// 2. MAIN COMPOSABLE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewProfileScreen(
    navController: NavController,
    viewModel: UserProfileViewModel = viewModel()
) {
    val userProfile = viewModel.userProfile.value
    // Definición de datos de perfil

    // Colores mock para el ejemplo
    val mainButtonColor = Color(0xFF3F51B5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen de Perfil
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color(0xFFB0D9E0)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = "Avatar",
                modifier = Modifier.size(80.dp),
                tint = Color(0xFF2C3E50)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre y Profesión
        Text(
            userProfile.fullName,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            userProfile.profession,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        ProfileDetailItem(
            icon = Icons.Default.Mail,
            label = "Correo",
            value = userProfile.email
        )
        Spacer(modifier = Modifier.height(12.dp))
        ProfileDetailItem(
            icon = Icons.Default.Phone,
            label = "Teléfono",
            value = userProfile.phone
        )
        Spacer(modifier = Modifier.height(12.dp))
        ProfileDetailItem(
            icon = Icons.Default.LocationOn,
            label = "Ubicación",
            value = userProfile.location
        )
        Spacer(modifier = Modifier.height(12.dp))
        ProfileDetailItem(
            icon = Icons.Default.School,
            label = "Formación",
            value = userProfile.academicFormation
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón Editar Perfil
        Button(
            // Uso de la ruta de navegación definida en la clase Screen
            onClick = { navController.navigate(Routes.EDIT_PROFILE) },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = mainButtonColor),
            modifier = Modifier
                .fillMaxWidth(0.8f) // 80% del ancho del contenedor
                .height(50.dp)
        ) {
            Text("Editar perfil", color = Color.White)
        }
    }
}


// 3. DETAIL ITEM COMPOSABLE

@Composable
fun ProfileDetailItem(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = label,
            tint = Color(0xFF3F51B5), // Icono azul
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(label, fontWeight = FontWeight.SemiBold, fontSize = 12.sp, color = Color.Gray)
            Text(value, fontSize = 16.sp)
        }
    }
}

// 4. PREVIEW

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    // Uso el tema por defecto de MaterialTheme. Si quieres usar MyApplicationTheme,
    // Me aseguro de que esté definido e importado correctamente en el proyecto.
    MaterialTheme {
        ViewProfileScreen(navController)
    }
}

/*
val userProfile = UserProfile(
fullName = "Andrea Fernández García",
profession = "Desarrolladora Android",
email = "andrea.fg@example.com",
phone = "+34 600 123 456",
location = "Madrid, España",
academicFormation = "DAM2 - Desarrollo de Aplicaciones Multiplataforma"
    )
 */