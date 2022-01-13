package com.tuwaiq.talktome.app.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.use_cases.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    fun getPost(): LiveData<List<Post>> = liveData(Dispatchers.IO) { getPostUseCase() }
}