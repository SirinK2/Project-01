package com.tuwaiq.talktome.app.auth

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.tuwaiq.talktome.domain.use_cases.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
    ) : ViewModel() {

        fun signIn(email:String, password:String): Task<AuthResult> = signInUseCase(email, password)

}