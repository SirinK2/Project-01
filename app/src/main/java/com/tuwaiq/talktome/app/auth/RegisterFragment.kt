package com.tuwaiq.talktome.app.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.tuwaiq.talktome.databinding.RegisterFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {



    private val viewModel by viewModels<RegisterViewModel>()
    lateinit var binding:RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerBtn.setOnClickListener {
            val name = binding.registerUsername.text.toString()
            val email = binding.registerEmail.text.toString()
            val pass = binding.registerPassword.text.toString()

            viewModel.register(email,pass)
        }
    }




}