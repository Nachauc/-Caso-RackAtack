package com.duoc.rackatack.ui.theme
import com.duoc.rackatack.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController

@Composable
fun ReconocimientoAntecedentes(navController: NavController){
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

        Text(text = "Reconocimiento de Componentes", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center

                ){
                    Image(
                        painter = painterResource(id = R.drawable.rack),
                        contentDescription = "imagen rack",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop

                    )

                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(text = "Componentes Reconocidos:", fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(8.dp))

                Text("• Patch panel",fontWeight = FontWeight.Bold)
                Text("panel de conexion de red")
                Text("(24 puertos)")
                Spacer(modifier = Modifier.height(2.dp))
                Text("• Switch",fontWeight = FontWeight.Bold)
                Text("switch de acceso")
                Text("(43 puertos)")
                Spacer(modifier = Modifier.height(2.dp))
                Text("• UPS",fontWeight = FontWeight.Bold)
                Text("sistema de alimentación ininterrumpida")
                Spacer(modifier = Modifier.height(2.dp))
                Text("• Servidor",fontWeight = FontWeight.Bold)
                Text("servidor del rack")
                Spacer(modifier = Modifier.height(2.dp))
                Text("• PDU",fontWeight = FontWeight.Bold)
                Text("Unidad de distribución de energía")
                Spacer(modifier = Modifier.height(2.dp))
                Text("• Firewall",fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(2.dp))
                Text("• Cableado Estructurado",fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ){
                    Text("Agregar componentes")
                }
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ){
                    Text("Editar componentes")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ){
                    Text("Eliminar componentes")
                }
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ){
                    Text("Catálogo de componentes")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("detalle") },
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "validar y guardar"
                    )
                }
                Text(text = "Validar y Guardar")
            }
        }
    }

}