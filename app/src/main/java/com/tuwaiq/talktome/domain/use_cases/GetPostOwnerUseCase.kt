package com.tuwaiq.talktome.domain.use_cases

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.repo.PostRepo
import javax.inject.Inject

class GetPostOwnerUseCase @Inject constructor(val repo: PostRepo) {

    suspend operator fun invoke(): List<Post> {

        val owner = Firebase.auth.currentUser?.uid

        val postList = mutableListOf<Post>()

        repo.getPosts().forEach {
            if (it.postOwner == owner){
                postList += it
            }
        }
        return postList
    }


}