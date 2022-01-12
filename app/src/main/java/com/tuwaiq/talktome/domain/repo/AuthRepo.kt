package com.tuwaiq.talktome.domain.repo

interface AuthRepo {


    fun register(email:String, password:String)

    fun signIn(email: String,password: String)
}