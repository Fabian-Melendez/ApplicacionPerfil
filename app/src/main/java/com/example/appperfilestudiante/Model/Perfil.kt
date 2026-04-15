package com.example.appperfilestudiante.Model

data class Perfil(
    val nombre: String,
    val programa: String,
    val semestre: Int,
    val descripcion: String,
    val edad: Int,
    val ciudad: String,
    val correo: String,
    val hobbies: List<String>,
    val pasatiempos: List<String>,
    val deportes: List<String>,
    val intereses: List<String>
)