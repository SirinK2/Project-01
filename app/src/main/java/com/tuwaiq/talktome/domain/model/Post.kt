package com.tuwaiq.talktome.domain.model

data class Post (
    val postText: String = "",
    val postPhotos: List<String> = listOf(),
    val postDate: String = "",
    val postOwner: String = "",
    var postId: String = ""
        )
