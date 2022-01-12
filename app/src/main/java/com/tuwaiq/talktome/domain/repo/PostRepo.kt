package com.tuwaiq.talktome.domain.repo

import com.tuwaiq.talktome.domain.model.Comment
import com.tuwaiq.talktome.domain.model.Like
import com.tuwaiq.talktome.domain.model.Post

interface PostRepo {

    suspend fun addPost(post: Post)

    suspend fun getPosts():List<Post>

    suspend fun addLike(like: Like)

    suspend fun getLikes():List<Like>

    suspend fun addComment(comment: Comment)

    suspend fun getComment():List<Comment>
}