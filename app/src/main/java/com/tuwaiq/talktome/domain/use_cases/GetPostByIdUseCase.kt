package com.tuwaiq.talktome.domain.use_cases

import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.repo.PostRepo
import javax.inject.Inject

class GetPostByIdUseCase @Inject constructor(private val repo: PostRepo) {

    suspend operator fun invoke(id:String):Post{

        var post = Post()
        repo.getPosts().forEach {
            if (post.postId == id){
                post = it
            }
        }

        return post
    }
}