package com.example.kasp101

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.kasp101.databinding.ActivitySimpleBinding

class SimpleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleBinding

    companion object {
        private const val TIMEOUT: Long = 2000
    }

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val animation = AnimationUtils.loadAnimation(this@SimpleActivity, R.anim.slide_up)
        binding.textViewTitle.startAnimation(animation)
    }

    override fun onResume() {
        super.onResume()
        binding.button1.setOnClickListener {
            binding.button2.visibility = View.VISIBLE
        }
        binding.button2.setOnClickListener {
            // special sleep to emulate ui block operation to check attempt method correctness
            handler.postDelayed({ binding.edit.visibility = View.VISIBLE }, TIMEOUT)
        }
    }
}
