package com.duoc.rackatack
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.duoc.rackatack.ui.theme.Navegacion
import com.duoc.rackatack.ui.theme.RackAtackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RackAtackTheme {

                Navegacion()




            }
        }
    }
}

