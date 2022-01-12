package com.tuwaiq.talktome.domain.model

data class User(
    val profilePhoto: String = "",
    val userName: String = "",
    val name: String = "",
    val bio: String = "",
    var userId: String = "",
    var userDoc: String = ""

)
