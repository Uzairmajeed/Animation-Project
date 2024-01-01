package com.facebook.animation_project

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.CycleInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.facebook.animation_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentValue = 1 // Initial value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        // Initialize views
        val neumorphCardView = binding.neumorphCardView1
        val textViewNumber = binding.texviewNumber
        val addButton = binding.AddButton
        val nextButton = binding.nextButton

        // Set click listener for the button
        addButton.setOnClickListener {
            // Increment the value by 5
            currentValue += 5

            // Update the TextView with the new value
            textViewNumber.text = currentValue.toString()

            // Call the shake animation method using ValueAnimator
            shakeView(addButton)
            shakeView(neumorphCardView)
        }
        // Set click listener for the "Next" button
        nextButton.setOnClickListener {
            // Create an ObjectAnimator to move the button from left to right
            val moveRightAnimator = ObjectAnimator.ofFloat(nextButton, "translationX", 0f, 800f)
            moveRightAnimator.duration = 500 // Animation duration in milliseconds
            moveRightAnimator.interpolator = AccelerateDecelerateInterpolator() // Optional: Add an interpolator for smooth acceleration and deceleration
            // Add a listener to start the new activity when the animation ends
            moveRightAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    // Optional: Handle onAnimationStart if needed
                }

                override fun onAnimationEnd(animation: Animator) {
                    // Start your new activity here
                    val intent = Intent(this@MainActivity, Objectactivity::class.java)
                    startActivity(intent)

                    // Reset the translationX to its initial position for future animations
                    nextButton.translationX = 0f
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

    // Shake animation method using ValueAnimator
    private fun shakeView(view: View) {
        val animator = ValueAnimator.ofFloat(0f, 10f, -10f, 10f, -10f, 5f, -5f, 0f)
        animator.duration = 500
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            view.translationX = value
        }
        animator.interpolator = CycleInterpolator(3F) // Adjust the cycle count as needed
        animator.start()
    }

}



