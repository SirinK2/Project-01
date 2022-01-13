package com.tuwaiq.talktome.domain.repo

import android.net.Uri
import com.tuwaiq.talktome.domain.model.Post

interface PostRepo {

    suspend fun addPost(post: Post)

    suspend fun getPosts():List<Post>

    suspend fun uploadPhotos(uri: List<Uri>): List<String>

}