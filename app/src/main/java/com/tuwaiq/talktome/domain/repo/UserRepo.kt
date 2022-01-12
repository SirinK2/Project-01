package com.tuwaiq.talktome.domain.repo

import com.tuwaiq.talktome.domain.model.User

interface UserRepo {

    suspend fun addUser(user: User)

    suspend fun getUser():List<User>
}