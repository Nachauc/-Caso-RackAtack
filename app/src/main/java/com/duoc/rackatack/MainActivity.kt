package com.duoc.rackatack
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.duoc.rackatack.models.AppDatabase
import com.duoc.rackatack.repository.LoginRepository
import com.duoc.rackatack.ui.theme.Navegacion
import com.duoc.rackatack.ui.theme.RackAtackTheme
import com.duoc.rackatack.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "login_db"
        ).build()
    }

    private val repository by lazy { LoginRepository(db.loginDao()) }
    private val viewModelRepository by lazy { LoginViewModel(repository) }

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

