package com.tuwaiq.talktome.data.repo

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tuwaiq.talktome.domain.model.User
import com.tuwaiq.talktome.domain.repo.UserRepo
import kotlinx.coroutines.tasks.await

private const val USER_COLLECTION = "user"
class UserRepoImpl:UserRepo {

    private val userCollectionRef = Firebase.firestore.collection(USER_COLLECTION)

    override suspend fun addUser(user: User) {
        user.userDoc = userCollectionRef.document().id
        userCollectionRef.add(user)
    }

    override suspend fun getUser(): List<User> =
        userCollectionRef
            .get()
            .await()
            .toObjects(User::class.java)


}