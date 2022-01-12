package com.tuwaiq.talktome.domain.use_cases

import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.repo.PostRepo
import javax.inject.Inject

class AddPostUseCase @Inject constructor(val repo: PostRepo) {

    suspend operator fun invoke(post: Post) = repo.addPost(post)

}