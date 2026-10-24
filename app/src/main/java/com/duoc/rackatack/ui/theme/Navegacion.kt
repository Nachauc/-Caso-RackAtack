package com.duoc.rackatack.ui.theme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun  Navegacion () {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "antecedentes"){
        composable ("login"){Login(navController)}
        composable("inicio"){InicioLevantamiento(navController)}
        composable("registro"){RegistroAntecedentes(navController)}
        composable("antecedentes"){ReconocimientoAntecedentes(navController)}
    }

    }