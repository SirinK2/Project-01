package com.tuwaiq.talktome.app.post

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tuwaiq.talktome.databinding.PostFragmentBinding
import com.tuwaiq.talktome.domain.model.Post
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class PostFragment : Fragment() {



    private val viewModel by viewModels<PostViewModel>()

    private lateinit var binding: PostFragmentBinding

    private lateinit var uriList: List<Uri>

    private lateinit var urlList: List<String>

    private val photosReg =
        registerForActivityResult(
            ActivityResultContracts
                .OpenMultipleDocuments()){
                uriList = it
        }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PostFragmentBinding.inflate(layoutInflater)





        return binding.root
    }


    override fun onStart() {
        super.onStart()

        binding.ivAddPic.setOnClickListener {
            photosReg.launch(arrayOf("image/*"))
        }

        binding.btnPost.setOnClickListener {
            val postText = binding.etAddPost.text.toString()
            val postDate = Date().toString()
            val postOwner = Firebase.auth.currentUser?.uid.toString()
            viewModel.uploadPhotos(uriList).observe(
                viewLifecycleOwner, {
                    urlList = it

                    val post = Post(postText,urlList,postDate,postOwner)

                    viewModel.addPost(post)
                }
            )
        }

    }


}