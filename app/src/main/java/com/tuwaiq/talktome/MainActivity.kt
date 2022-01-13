package com.tuwaiq.talktome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tuwaiq.talktome.app.auth.SignInFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var logo: ImageView
    private lateinit var tvTitle: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = Firebase.auth.currentUser
        if (user == null) {
            findNavController(R.id.fragmentContainerView2).navigate(R.id.registerFragment)
        }





//        // Will later change it to a splash fragment instead of main activity
//        supportActionBar?.hide()
//
//        // Animation for Lottie
//        logo = findViewById(R.id.anim_talktome)
//        // Setting up two animations with their respective time to make them smoother
//        logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))
//        Handler().postDelayed({
//            logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
//            Handler().postDelayed({
//                logo.visibility = View.GONE
//                startActivity(Intent(this, SignInFragment::class.java))
//                finish()
//            },500)
//        },3000)
//
//        // Animation for the Title
//        tvTitle = findViewById(R.id.app_title)
//
//        tvTitle.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))
//        Handler().postDelayed({
//            tvTitle.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
//            Handler().postDelayed({
//                tvTitle.visibility = View.GONE
//                startActivity(Intent(this, SignInFragment::class.java))
//                finish()
//            },500)
//        },3000)
    }
}