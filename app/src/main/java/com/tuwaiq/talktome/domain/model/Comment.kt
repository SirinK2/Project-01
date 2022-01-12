package com.tuwaiq.talktome.domain.model

data class Comment(
    val userId:String = "",
    val postId:String = "",
    val comment: String = ""
)