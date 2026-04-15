package com.example.appperfilestudiante.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appperfilestudiante.ViewModel.PerfilViewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import com.example.appperfilestudiante.R
import com.example.appperfilestudiante.ui.theme.AzulOscuro
import com.example.appperfilestudiante.ui.theme.GrisClaro


@Preview(showBackground = true)
@Composable
fun PreviewPantallaPerfil() {
    PantallaPerfil(
        navController = rememberNavController()
    )
}

@Composable
fun PantallaPerfil(
    navController: NavController,
    vm: PerfilViewModel = viewModel()
) {

    val perfil = vm.perfil

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulOscuro)
    ) {

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = GrisClaro
            )
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {

                    Spacer(modifier = Modifier.height(20.dp))

                    // 📸 Foto centrada
                    Image(
                        painter = painterResource(id = R.drawable.foto_perfil),
                        contentDescription = "Foto",
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = perfil.nombre,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                }

                // 🔹 Tarjetas de info
                item { TarjetaDato("Programa", perfil.programa) }
                item { TarjetaDato("Semestre", perfil.semestre.toString()) }
                item { TarjetaDato("Ciudad", perfil.ciudad) }
                item { TarjetaDato("Correo", perfil.correo) }
                item { TarjetaDato("Descripción", perfil.descripcion) }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }

                // 🔥 Dashboard abajo
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        DashboardItem(
                            titulo = "Detalles",
                            modifier = Modifier.weight(1f)
                        ) {
                            navController.navigate("detalles")
                        }

                        DashboardItem(
                            titulo = "Más",
                            modifier = Modifier.weight(1f)
                        ) {
                            // futura pantalla si quieres
                        }
                    }
                }
            }
        }
    }
}

// 🔹 Tarjeta de datos
@Composable
fun TarjetaDato(titulo: String, contenido: String) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = titulo,
                style = MaterialTheme.typography.titleSmall,
                color = AzulOscuro
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = contenido,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

