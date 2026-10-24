package com.duoc.rackatack.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegistroAntecedentes(navController: NavController){
    var idRack by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var responsable by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("Volver")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Registro de Antecedentes", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = idRack,
                    onValueChange = {nuevoTexto -> idRack = nuevoTexto},
                    label = {Text("ID Rack")},
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = fecha,
                    onValueChange = {nuevoTexto -> fecha = nuevoTexto},
                    label = {Text("Fecha")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = responsable,
                    onValueChange = {nuevoTexto -> responsable = nuevoTexto},
                    label = {Text("Responsable")},
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = observaciones,
                    onValueChange = {nuevoTexto -> observaciones = nuevoTexto},
                    label = {Text("Nota de Inspección")},
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.weight(1f)
            ){
                Text("Rack Frame")
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f)
            ){
                Text("Network Switch")
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
                Text("PDU")
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f)
            ){
                Text("Cable Manager")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("camara") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "📸 Continuar a Captura de fotografía")
        }

    }
}