package com.tuwaiq.talktome.app.auth

import androidx.lifecycle.ViewModel
import com.tuwaiq.talktome.domain.use_cases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
    ) : ViewModel() {

        fun signIn(email:String, password:String) = signInUseCase(email, password)

}