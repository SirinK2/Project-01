package com.tuwaiq.talktome.app.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tuwaiq.talktome.databinding.SignInFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {


    private val viewModel by viewModels<SignInViewModel>()
    private lateinit var binding: SignInFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.signInBtn.setOnClickListener {
            val email= binding.signInEmail.text.toString()
            val pass = binding.signInPassword.text.toString()

            viewModel.signIn(email,pass)

        }
    }



}