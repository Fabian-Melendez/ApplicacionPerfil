package com.example.appperfilestudiante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.appperfilestudiante.ui.screens.PantallaBienvenida
import com.example.appperfilestudiante.ui.screens.PantallaPerfil
import com.example.appperfilestudiante.ui.screens.PantallaDetalles
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavegacion()
        }
    }
}

@Composable
fun AppNavegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "bienvenida"
    ) {

        composable("bienvenida") {
            PantallaBienvenida(navController)
        }

        composable("perfil") {
            PantallaPerfil(navController)
        }

        composable("detalles") {
            PantallaDetalles(navController)
        }
    }
}