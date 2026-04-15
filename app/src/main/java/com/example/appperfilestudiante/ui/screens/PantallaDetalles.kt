package com.example.appperfilestudiante.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appperfilestudiante.ViewModel.PerfilViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.appperfilestudiante.R
import com.example.appperfilestudiante.ui.theme.AzulOscuro
import com.example.appperfilestudiante.ui.theme.GrisClaro

@Preview(showBackground = true)
@Composable
fun PreviewPantallaDetalles() {
    PantallaDetalles(navController = rememberNavController())
}
@Composable
fun SeccionPlegable(
    titulo: String,
    lista: List<String>?,
    icono: Int
) {
    var expandido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expandido = !expandido },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = icono),
                    contentDescription = titulo,
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium,
                    color = AzulOscuro
                )
            }

            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))

                // evita crash si lista es null
                lista?.forEach {
                    Text(text = "• $it")
                }
            }
        }
    }
}
@Composable
fun PantallaDetalles(
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
            colors = CardDefaults.cardColors(containerColor = GrisClaro)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // 🔹 Título
                item {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Text(
                            text = "Más detalles",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                item { SeccionPlegable("Hobbies", perfil.hobbies, R.drawable.auriculares) }
                item { SeccionPlegable("Pasatiempos", perfil.pasatiempos, R.drawable.consola) }
                item { SeccionPlegable("Deportes", perfil.deportes, R.drawable.ping_pong) }
                item { SeccionPlegable("Intereses", perfil.intereses, R.drawable.telefono_movil) }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        DashboardItem(
                            titulo = "Perfil",
                            modifier = Modifier.weight(1f)
                        ) {
                            navController.navigate("perfil")
                        }

                        DashboardItem(
                            titulo = "Inicio",
                            modifier = Modifier.weight(1f)
                        ) {
                            navController.navigate("bienvenida")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun DashboardItem(
    titulo: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(90.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}