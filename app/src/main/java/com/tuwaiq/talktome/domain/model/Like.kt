package com.tuwaiq.talktome.domain.model

data class Like (
    val postId: String = "",
    val likes : List<String> = listOf()
        )