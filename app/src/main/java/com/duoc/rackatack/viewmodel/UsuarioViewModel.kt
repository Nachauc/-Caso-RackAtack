package com.duoc.rackatack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.rackatack.models.Usuario
import com.duoc.rackatack.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel : ViewModel() {
    private val repository = UsuarioRepository()

    fun registrarUsuario(
        usuario: Usuario,
        onExito: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                repository.registrarUsuario(usuario)
                onExito()
            } catch (e: Exception) {
                onError("Error al registrar usuario en la nube: ${e.message}")
            }
        }
    }

    fun validarLogin(
        correo: String,
        password: String,
        onExito: (Usuario) -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val listaUsuarios = repository.obtenerUsuarios()
                val encontrado = listaUsuarios.find {
                    it.correo.equals(correo.trim(), ignoreCase = true) && it.password == password
                }
                if (encontrado != null) {
                    onExito(encontrado)
                } else {
                    onError("Correo o contraseña incorrectos.")
                }
            } catch (e: Exception) {
                onError("Error de conexión con el servidor.")
            }
        }
    }
}