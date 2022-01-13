package com.tuwaiq.talktome.domain.use_cases

import android.net.Uri
import com.tuwaiq.talktome.domain.repo.PostRepo
import javax.inject.Inject

class UploadPhotosUseCase @Inject constructor(private val repo: PostRepo) {

    suspend operator fun invoke(uri: List<Uri>) = repo.uploadPhotos(uri)
}