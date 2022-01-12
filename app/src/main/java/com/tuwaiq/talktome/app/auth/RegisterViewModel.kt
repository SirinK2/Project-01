package com.tuwaiq.talktome.app.auth

import androidx.lifecycle.ViewModel
import com.tuwaiq.talktome.domain.use_cases.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase : RegisterUseCase
    ): ViewModel() {

    fun register(email:String,password:String) = registerUseCase(email, password)

}