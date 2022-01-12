package com.tuwaiq.talktome.domain.use_cases

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tuwaiq.talktome.domain.model.User
import com.tuwaiq.talktome.domain.repo.UserRepo
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(val repo: UserRepo) {

    suspend operator fun invoke():User {

        var user = User()
        val userId = Firebase.auth.currentUser?.uid
        repo.getUser().forEach {
            if (it.userId == userId){
                user = it
            }
        }

        return user
    }
}