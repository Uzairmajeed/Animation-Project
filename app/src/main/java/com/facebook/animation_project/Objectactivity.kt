package com.facebook.animation_project

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.facebook.animation_project.databinding.ActivityObjectactivityBinding

class Objectactivity : AppCompatActivity() {
    private lateinit var binding: ActivityObjectactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityObjectactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Get references to NeumorphImageButton views
        val neumorphImageButtonCar = binding.neumorphImageButtonCar
        val neumorphImageButtonBike = binding.neumorphImageButtonBike

        // Create ObjectAnimator for the car (move continuously left and right)
        val carAnimator = ObjectAnimator.ofFloat(neumorphImageButtonCar, "translationX", -800f, 800f)
        carAnimator.duration = 3000 // Animation duration in milliseconds
        carAnimator.repeatCount = ObjectAnimator.INFINITE // Repeat the animation indefinitely
        carAnimator.reverse() // Reverse the animation for smooth continuous movement
        carAnimator.start()

        // Create ObjectAnimator for the bike (move continuously left and right)
        val bikeAnimator = ObjectAnimator.ofFloat(neumorphImageButtonBike, "translationX", -800f, 800f)
        bikeAnimator.duration = 3000 // Animation duration in milliseconds
        bikeAnimator.repeatCount = ObjectAnimator.INFINITE // Repeat the animation indefinitely
        bikeAnimator.reverse() // Reverse the animation for smooth continuous movement
        bikeAnimator.start()

        // Set click listener for the "Next" button
        binding.nextButton.setOnClickListener {
            // Create an ObjectAnimator to move the button from left to right
            val moveRightAnimator = ObjectAnimator.ofFloat(binding.nextButton, "translationX", 0f, 800f)
            moveRightAnimator.duration = 500 // Animation duration in milliseconds
            moveRightAnimator.interpolator = AccelerateDecelerateInterpolator() // Optional: Add an interpolator for smooth acceleration and deceleration
            // Add a listener to start the new activity when the animation ends
            moveRightAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    // Optional: Handle onAnimationStart if needed
                }

                override fun onAnimationEnd(animation: Animator) {
                    // Start your new activity here
                    val intent = Intent(this@Objectactivity, LottieActivity::class.java)
                    startActivity(intent)

                    // Reset the translationX to its initial position for future animations
                    binding.nextButton.translationX = 0f
                }

                override fun onAnimationCancel(animation: Animator) {
                    // Optional: Handle onAnimationCancel if needed
                }

                override fun onAnimationRepeat(animation: Animator) {
                    // Optional: Handle onAnimationRepeat if needed
                }
            })
            // Start the move-right animation
            moveRightAnimator.start()
        }
    }
}
