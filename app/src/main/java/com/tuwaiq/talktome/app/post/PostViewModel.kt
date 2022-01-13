package com.tuwaiq.talktome.app.post

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.use_cases.AddPostUseCase
import com.tuwaiq.talktome.domain.use_cases.UploadPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val addPostUseCase: AddPostUseCase,
    private val uploadPhotosUseCase: UploadPhotosUseCase
): ViewModel() {

    fun addPost(post:Post) = viewModelScope.launch(Dispatchers.IO) { addPostUseCase(post) }

    fun uploadPhotos(uri:List<Uri>): LiveData<List<String>> =
        liveData(Dispatchers.IO) { uploadPhotosUseCase(uri) }




}