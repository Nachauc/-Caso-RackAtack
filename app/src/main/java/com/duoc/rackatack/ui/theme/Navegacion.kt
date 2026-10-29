package com.duoc.rackatack.ui.theme
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
@Composable
fun  Navegacion () {
    val navController = rememberNavController()
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("mispreferencias", Context.MODE_PRIVATE)
    val isLoggedIn  = sharedPreferences.getBoolean("isLoggedIn",false)
    val rutaInicial = if (isLoggedIn) "inicio" else "login"

    NavHost(navController= navController ,startDestination = rutaInicial){
        composable ("login"){Login(navController)}
        composable("inicio"){InicioLevantamiento(navController)}
        composable("registro"){RegistroAntecedentes(navController)}
        composable("antecedentes"){ReconocimientoAntecedentes(navController)}
        composable ("detalle"){DetalleLevantamiento(navController)}
        composable("camara"){Camara(navController)}
        }

    }