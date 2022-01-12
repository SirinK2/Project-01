package com.tuwaiq.talktome.app.post

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuwaiq.talktome.R
import com.tuwaiq.talktome.databinding.PostFragmentBinding

class PostFragment : Fragment() {



    private lateinit var viewModel: PostViewModel

    private lateinit var binding: PostFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PostFragmentBinding.inflate(layoutInflater)

        return binding.root
    }


}