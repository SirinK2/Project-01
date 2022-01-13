package com.tuwaiq.talktome.data.repo

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.tuwaiq.talktome.domain.repo.AuthRepo

class AuthRepoImpl:AuthRepo {

    private val auth = FirebaseAuth.getInstance()

    override fun register(email: String, password: String): Task<AuthResult> =
        auth.createUserWithEmailAndPassword(
            email,
            password
        )




    override fun signIn(email: String, password: String): Task<AuthResult> =
        auth.signInWithEmailAndPassword(
            email,
            password
        )







}