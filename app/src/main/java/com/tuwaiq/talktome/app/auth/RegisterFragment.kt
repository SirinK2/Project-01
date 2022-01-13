package com.tuwaiq.talktome.app.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tuwaiq.talktome.R
import com.tuwaiq.talktome.databinding.RegisterFragmentBinding
import com.tuwaiq.talktome.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "RegisterFragment"
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
        binding.btnSignup.setOnClickListener {
            val name = binding.etNameReg.text.toString()
            val email = binding.etEmailReg.text.toString()
            val pass = binding.etPasswordReg.text.toString()


            viewModel.register(email,pass).addOnCompleteListener {

                if (it.isSuccessful){
                    val userId = Firebase.auth.currentUser?.uid.toString()
                    val user = User(name,userId)
                    viewModel.addUser(user)
                    findNavController().popBackStack(R.id.homepageFragment,false)
                }
            }.addOnFailureListener {
                Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
                Log.e(TAG, "onStart: ${it.localizedMessage} " )
            }
        }
    }




}