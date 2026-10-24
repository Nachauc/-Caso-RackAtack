package com.duoc.rackatack.ui.theme
import com.duoc.rackatack.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var modal by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFBBDEFB)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(
            painter = painterResource(id= R.drawable.cmc360_logo),
            contentDescription = "logoEmpresa",
            modifier = Modifier.width(200.dp).height(200.dp).padding(bottom = 30.dp)
        )

        Text(text = "Correo Institucional")

        OutlinedTextField(
            value = username,
            onValueChange = {nuevoTexto ->
                username = nuevoTexto
            },
            label = {Text("Introduce tu Correo")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Contraseña")

        OutlinedTextField(
            value = password,
            onValueChange = {nuevoTexto ->
                password = nuevoTexto
            },
            label = {Text("Introduce tu contraseña")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(42.dp))

        Button(
            onClick = {navController.navigate("inicio")},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text ="Ingresar")
        }
        //if(modal){
           // AlertDialog(
               // onDismissRequest = {modal = false},
               // title = {Text("Mensaje")},
               // text ={Text ("se debe crear el usuario :$username con la contraseña: $password")},
               // confirmButton = {
                   // Button(onClick = {modal = false}) {
                     //   Text("ok")
                   // }
               // }
            //)
        //}
    }
















}