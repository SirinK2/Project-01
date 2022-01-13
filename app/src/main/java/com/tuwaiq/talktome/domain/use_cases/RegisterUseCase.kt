package com.tuwaiq.talktome.domain.use_cases

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.tuwaiq.talktome.data.repo.AuthRepoImpl
import com.tuwaiq.talktome.domain.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class RegisterUseCase @Inject constructor(private val repo: AuthRepo) {

    operator fun invoke(email: String, password:String): Task<AuthResult> =
        repo.register(email, password)

}