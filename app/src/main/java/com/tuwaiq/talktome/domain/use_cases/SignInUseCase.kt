package com.tuwaiq.talktome.domain.use_cases

import com.tuwaiq.talktome.data.repo.AuthRepoImpl
import com.tuwaiq.talktome.domain.repo.AuthRepo
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val repo: AuthRepo) {


    operator fun invoke(email:String,password:String) = repo.signIn(email, password)

}