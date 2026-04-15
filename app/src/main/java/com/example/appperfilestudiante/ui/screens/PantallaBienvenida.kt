package com.example.appperfilestudiante.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.animation.core.*
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import com.example.appperfilestudiante.R
import com.example.appperfilestudiante.ui.theme.AzulOscuro
import com.example.appperfilestudiante.ui.theme.GrisClaro


@Preview(showBackground = true)
@Composable
fun PreviewPantallaBienvenida() {
    PantallaBienvenida(navController = rememberNavController())
}

@Composable
fun PantallaBienvenida(navController: NavController) {

    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500)
        startAnimation = true
        delay(2500)
        navController.navigate("perfil") {
            popUpTo("bienvenida") { inclusive = true }
        }
    }

    val offsetY by animateIntAsState(
        targetValue = if (startAnimation) -80 else 0,
        animationSpec = tween(1000, easing = FastOutSlowInEasing),
        label = ""
    )

    val alphaNombre by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(1500),
        label = ""
    )

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

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.offset(y = 60.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.mochila),
                        contentDescription = "Mochila",
                        modifier = Modifier
                            .size(120.dp)
                            .offset { IntOffset(0, offsetY) }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Perfil estudiantil",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.offset { IntOffset(0, offsetY) },
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Fabian Melendez",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.alpha(alphaNombre),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}