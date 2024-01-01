package com.facebook.animation_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.animation_project.databinding.ActivityLottieBinding

class LottieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLottieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLottieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.handshake.playAnimation()
    }
}