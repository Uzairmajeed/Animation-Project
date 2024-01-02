package com.facebook.animation_project

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.TransitionManager
import com.facebook.animation_project.databinding.ActivityLottieBinding
import com.google.android.material.transition.MaterialSharedAxis

class LottieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLottieBinding
    private var isCarAnimVisible = true // Start with the car animation visible

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLottieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start playing the initial animation
        binding.Caranim.playAnimation()

        // Set click listener for the "navbackbutton"
        binding.navbackbutton.setOnClickListener {
            // Toggle the visibility flag
            isCarAnimVisible = !isCarAnimVisible

            // Apply the MaterialSharedAxis transition
            val transition = MaterialSharedAxis(MaterialSharedAxis.Z, isCarAnimVisible)
                .apply { duration = 2000 } // Set the duration here
            TransitionManager.beginDelayedTransition(binding.constraintLayout, transition)

            // Toggle the visibility of animations based on the flag
            binding.Caranim.visibility = if (isCarAnimVisible) View.VISIBLE else View.INVISIBLE
            binding.handshakeanim.visibility = if (isCarAnimVisible) View.INVISIBLE else View.VISIBLE

            // Play the appropriate animation
            if (isCarAnimVisible) {
                binding.Caranim.playAnimation()
            } else {
                binding.handshakeanim.playAnimation()
            }
        }
    }
}
