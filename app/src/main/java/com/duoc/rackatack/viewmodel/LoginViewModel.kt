package com.duoc.rackatack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.rackatack.models.Users
import com.duoc.rackatack.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository): ViewModel() {


    fun agregarLogin(correo: Users){
        viewModelScope.launch {
            repository.insert(correo)

        }
    }

}