package es.fpsumma.dam2.myapplication.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.fpsumma.dam2.myapplication.ui.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    // Color de ejemplo
    val placeholderColor2 = Color(0xFF90CAF9)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Saludo
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("👋", fontSize = 24.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Hola, usuario!",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Mensaje de bienvenida
        Text("Esta es tu pantalla de inicio. Desde aquí puedes acceder a diferentes secciones.")

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta de información (El "¿Sabías qué...?")
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEAF4FF)), // Azul claro
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "¿Sabías qué...?",
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E88E5) // Azul más oscuro
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Puedes navegar entre pantallas usando el NavController en Compose. ¡Explora abajo!",
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botones de navegación
        Button(
            onClick = { navController.navigate(Routes.PROFILE) }, // Ruta de navegación a Perfil
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)) // Azul oscuro
        ) {
            Text("Ver perfil", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            // Podríamos crear una ruta 'SETTINGS' en Routes.kt y usarla aquí:
            onClick = { /* navController.navigate(Routes.SETTINGS) */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = placeholderColor2)
        ) {
            Text("Configuración", color = Color.White)
        }
    }
}