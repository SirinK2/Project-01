package com.tuwaiq.talktome.data.repo

import com.google.firebase.auth.FirebaseAuth
import com.tuwaiq.talktome.domain.repo.AuthRepo

class AuthRepoImpl:AuthRepo {

    private val auth = FirebaseAuth.getInstance()

    override fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(
            email,
            password
        )
    }



    override fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(
            email,
            password
        )
    }






}