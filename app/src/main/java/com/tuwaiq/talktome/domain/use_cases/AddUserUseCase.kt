package com.tuwaiq.talktome.domain.use_cases

import com.tuwaiq.talktome.domain.model.User
import com.tuwaiq.talktome.domain.repo.UserRepo
import javax.inject.Inject

class AddUserUseCase @Inject constructor(private val repo: UserRepo) {

    suspend operator fun invoke(user: User) = repo.addUser(user)


}