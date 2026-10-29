package com.duoc.rackatack.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun RegistroAntecedentes(navController: NavController){

    val fechaDeHoy = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date()) }
    var fecha by remember { mutableStateOf(fechaDeHoy) }
    var idRack by remember { mutableStateOf("") }
    var responsable by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }
    var modal by remember { mutableStateOf(false)}
    val opciones = listOf("Alan Alfaro", "Maria Ignacia Urrutia")
    var expandido by remember { mutableStateOf(false) }
    var seleccionado by remember { mutableStateOf("Selecciona un encargado") }

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
                    onValueChange = {},
                    label = {Text("Fecha")},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = seleccionado,
                        onValueChange = {},
                        label = { Text("Encargado") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Desplegar")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expandido = true }
                    )

                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .clickable { expandido = true }
                    )

                    DropdownMenu(
                        expanded = expandido,
                        onDismissRequest = { expandido = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        opciones.forEach { opcion ->
                            DropdownMenuItem(
                                text = { Text(opcion) },
                                onClick = {
                                    seleccionado = opcion
                                    responsable = opcion
                                    expandido = false
                                }
                            )
                        }
                    }
                }

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
            onClick = {
                if (idRack.isBlank() || fecha.isBlank() || responsable.isBlank() || observaciones.isBlank()) {
                    modal = true
                } else {
                    navController.navigate("camara")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "📸 Continuar a Captura de fotografía")
        }

        if(modal){
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { modal = false },
                title = { Text(text = "Faltan datos.")},
                text = { Text(text = "Por favor, completa todos los campos para continuar.")},
                confirmButton = {
                    Button(onClick = { modal = false }) {
                        Text(text = "Aceptar")
                    }
                }
            )
        }

    }
}