package com.example.appperfilestudiante.ViewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.appperfilestudiante.Model.Perfil

class PerfilViewModel : ViewModel() {

    var perfil by mutableStateOf(
        Perfil(
            nombre = "Fabian Guillermo Melendez",
            programa = "Programa: Ingeniería de Sistemas y Computacion",
            semestre = 5,
            descripcion = "Soy un estudiante apasionado al deporte y a la tecnologia.",
            edad = 20,
            ciudad = "Chia",
            correo = "fabianmelendez@email.com",
            hobbies = listOf("Programar", "Escuchar música"),
            pasatiempos = listOf("Videojuegos", "Series"),
            deportes = listOf("PingPong", "Futbol"),
            intereses = listOf("IA", "Desarrollo móvil", "Bases de datos")
        )
    )
        private set

    var mostrarDetalles by mutableStateOf(false)
        private set

    fun toggleDetalles() {
        mostrarDetalles = !mostrarDetalles
    }
}