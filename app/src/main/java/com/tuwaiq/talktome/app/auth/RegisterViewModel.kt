package com.tuwaiq.talktome.app.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.tuwaiq.talktome.domain.model.User
import com.tuwaiq.talktome.domain.use_cases.AddUserUseCase
import com.tuwaiq.talktome.domain.use_cases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase : RegisterUseCase,
    private val addUserUseCase: AddUserUseCase
    ): ViewModel() {

    fun register(email:String,password:String): Task<AuthResult> = registerUseCase(email, password)

    fun addUser(user:User) = viewModelScope.launch (Dispatchers.IO){ addUserUseCase(user) }

}