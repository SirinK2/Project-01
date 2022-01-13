package com.tuwaiq.talktome.app.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.model.User
import com.tuwaiq.talktome.domain.use_cases.GetCurrentUserUseCase
import com.tuwaiq.talktome.domain.use_cases.GetPostOwnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val getPostOwnerUseCase: GetPostOwnerUseCase
): ViewModel() {

    fun getUser(): LiveData<User> = liveData(Dispatchers.IO) { getCurrentUserUseCase() }


    fun getPost(): LiveData<List<Post>> = liveData(Dispatchers.IO) { getPostOwnerUseCase() }

}