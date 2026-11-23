package com.duoc.rackatack.ui.theme
import android.content.Context
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duoc.rackatack.viewmodel.UsuarioViewModel

@Composable
fun Login(
    navController: NavController,
    usuarioViewModel: UsuarioViewModel = viewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var modal by remember { mutableStateOf(false) }
    var mensajeError by remember { mutableStateOf("Por favor, ingrese su correo y contraseña.") }
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("mispreferencias", Context.MODE_PRIVATE)
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cmc360_logo),
            contentDescription = "logoEmpresa",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(bottom = 30.dp)
        )

        Text(text = "Correo Institucional")

        OutlinedTextField(
            value = username,
            onValueChange = { nuevoTexto ->
                username = nuevoTexto
            },
            label = { Text("Introduce tu Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Contraseña")

        OutlinedTextField(
            value = password,
            onValueChange = { nuevoTexto ->
                password = nuevoTexto
            },
            label = { Text("Introduce tu contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(42.dp))

        BotonCargando(
            texto = "Ingresar",
            cargando = isLoading,
            onClick = {
                if (username.isBlank() || password.isBlank()) {
                    mensajeError = "Por favor, ingrese su correo y contraseña."
                    modal = true
                } else {
                    isLoading = true
                    usuarioViewModel.validarLogin(
                        correo = username,
                        password = password,
                        onExito = { usuarioEncontrado ->
                            isLoading = false
                            val editor = sharedPreferences.edit()
                            editor.putBoolean("isLoggedIn", true)
                            editor.putString("correo_usuario", usuarioEncontrado.correo)
                            editor.apply()

                            navController.navigate("inicio") {
                                popUpTo("login") { inclusive = true }
                            }
                        },
                        onError = { error ->
                            isLoading = false
                            mensajeError = error
                            modal = true
                        }
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate("registroUsuario") }) {
            Text("¿No tienes cuenta? Regístrate aquí")
        }

        if (modal) {
            AlertDialog(
                onDismissRequest = { modal = false },
                title = { Text(text = "Atención") },
                text = { Text(text = mensajeError) },
                confirmButton = {
                    Button(onClick = { modal = false }) {
                        Text(text = "Aceptar")
                    }
                }
            )
        }
    }
}