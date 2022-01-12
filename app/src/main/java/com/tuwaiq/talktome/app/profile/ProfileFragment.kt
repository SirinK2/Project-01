package com.tuwaiq.talktome.app.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuwaiq.talktome.R
import com.tuwaiq.talktome.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {



    private lateinit var viewModel: ProfileViewModel

    lateinit var binding: ProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
        return binding.root
    }



}