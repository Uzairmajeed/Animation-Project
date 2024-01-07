package com.facebook.animation_project

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Fade
import androidx.transition.TransitionManager
import com.facebook.animation_project.databinding.ActivityCallerDesignBinding
import soup.neumorphism.NeumorphFloatingActionButton

class CallerDesign : AppCompatActivity() {
    private lateinit var binding: ActivityCallerDesignBinding
    private var isDialpadVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallerDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val neumorphicFab=binding.floatingActionButton
        val dialpadContainer: FrameLayout = findViewById(R.id.dialpadContainer)

        neumorphicFab.setOnClickListener {
            // Toggle the visibility flag
            isDialpadVisible = !isDialpadVisible

            // Apply the Material Fade transition
            val transition = Fade()
                .setDuration(500) // Set the duration here
            TransitionManager.beginDelayedTransition(binding.root, transition)

            // Toggle the visibility of the dialpad container based on the flag
            dialpadContainer.visibility = if (isDialpadVisible) View.VISIBLE else View.GONE
        }
    }
}
