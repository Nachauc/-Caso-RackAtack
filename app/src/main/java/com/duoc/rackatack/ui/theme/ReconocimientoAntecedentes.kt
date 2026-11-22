package com.duoc.rackatack.ui.theme

import android.Manifest
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.duoc.rackatack.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.viewmodel.LevantamientoViewModel
import androidx.activity.compose.LocalActivity
@Composable
fun ReconocimientoAntecedentes(navController: NavController,
                               viewModel: LevantamientoViewModel = viewModel(LocalActivity.current as ComponentActivity)){
    val context = LocalContext.current

    val permisoNotificacionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { concedido ->
            if (concedido) {
                mostrarNotificacionLevantamiento(
                    context,
                    "Levantamiento Guardado",
                    "El rack ${viewModel.tempRackId} se registró en la nube."
                )
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB))
            .statusBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "volver"
                )
            }
            Text("Volver")

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Detalle y Reconocimiento", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rack),
                    contentDescription = "imagen rack",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Rack: ${viewModel.tempRackId.ifBlank { "Sin ID" }}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Fecha: ${viewModel.tempFecha.ifBlank { "Hoy" }}", fontSize = 14.sp)
                    Text("Encargado: ${viewModel.tempInspector.ifBlank { "No asignado" }}", fontSize = 14.sp)
                    if (viewModel.tempObservaciones.isNotBlank()) {
                        Text("Nota: ${viewModel.tempObservaciones}", fontSize = 13.sp, color = Color.DarkGray)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 2. LAZY COLUMN INFERIOR: Información y Componentes Reconocidos
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        text = "Componentes Reconocidos:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }

                item {
                    Text("• Patch panel", fontWeight = FontWeight.Bold)
                    Text("Panel de conexión de red (24 puertos)", fontSize = 14.sp)
                }

                item {
                    Text("• Switch", fontWeight = FontWeight.Bold)
                    Text("Switch de acceso (48 puertos)", fontSize = 14.sp)
                }

                item {
                    Text("• UPS", fontWeight = FontWeight.Bold)
                    Text("Sistema de alimentación ininterrumpida", fontSize = 14.sp)
                }

                item {
                    Text("• Servidor", fontWeight = FontWeight.Bold)
                    Text("Servidor principal del rack", fontSize = 14.sp)
                }

                item {
                    Text("• PDU", fontWeight = FontWeight.Bold)
                    Text("Unidad de distribución de energía", fontSize = 14.sp)
                }

                item {
                    Text("• Firewall", fontWeight = FontWeight.Bold)
                    Text("Seguridad perimetral activa", fontSize = 14.sp)
                }

                item {
                    Text("• Cableado Estructurado", fontWeight = FontWeight.Bold)
                    Text("Ordenamiento vertical y horizontal", fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3. BOTONES DE ACCIÓN INFERIORES
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "compartir"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Exportar")
            }

            Button(
                onClick = {
                    // 1. Crear objeto y enviarlo a Xano
                    val nuevoRegistro = Levantamiento(
                        rackId = viewModel.tempRackId,
                        fecha = viewModel.tempFecha,
                        inspector = viewModel.tempInspector,
                        estado = viewModel.tempObservaciones

                    )
                    viewModel.guardarLevantamiento(nuevoRegistro)

                    // 2. Disparar notificación nativa
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        permisoNotificacionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    } else {
                        mostrarNotificacionLevantamiento(
                            context,
                            "Levantamiento Guardado",
                            "El rack ${viewModel.tempRackId} se registró en la nube."
                        )
                    }

                    // 3. Volver directamente al Inicio para ver la lista actualizada
                    navController.navigate("inicio") {
                        popUpTo("inicio") { inclusive = true }
                    }
                },
                modifier = Modifier.weight(1.4f)
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "validar y guardar"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Validar y Guardar")
            }
        }
    }

}