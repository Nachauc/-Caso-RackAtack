package com.duoc.rackatack.ui.theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.viewmodel.LevantamientoViewModel
@Composable
fun InicioLevantamiento(navController: NavController,
    viewModel: LevantamientoViewModel = viewModel()) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB))
    ) {
        Column(modifier = Modifier.statusBarsPadding()) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Volver")
            }

            LazyColumn(
                contentPadding = PaddingValues(30.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.levantamientos) { LevantamientoCard(it) }
            }
        }

        Button(
            onClick = { navController.navigate("registro") },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .height(60.dp)


        ) {
            Text("Nuevo Levantamiento +", fontSize = 18.sp)
        }
    }
}


@Composable
fun LevantamientoCard(item: Levantamiento){
    Card(modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Rack ID: ${item.rackId}")
            Text("Fecha: ${item.fecha}")
            Text("Inspector: ${item.inspector}")
            Text("Estado: ${item.estado}")
        }
    }
}