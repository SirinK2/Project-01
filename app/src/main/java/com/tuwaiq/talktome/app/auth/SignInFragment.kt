package com.tuwaiq.talktome.app.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tuwaiq.talktome.R
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

        binding.btnSignIn.setOnClickListener {
            val email= binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            viewModel.signIn(email,pass).addOnCompleteListener {

                if (it.isSuccessful){
                    findNavController().popBackStack(R.id.homepageFragment,false)
                }
            }.addOnFailureListener {
                Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }
    }



}