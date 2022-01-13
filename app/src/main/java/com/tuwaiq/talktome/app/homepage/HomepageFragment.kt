package com.tuwaiq.talktome.app.homepage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tuwaiq.talktome.R
import com.tuwaiq.talktome.databinding.HomepageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {



    private val viewModel by viewModels<HomepageViewModel>()
    private lateinit var binding: HomepageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomepageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }





}