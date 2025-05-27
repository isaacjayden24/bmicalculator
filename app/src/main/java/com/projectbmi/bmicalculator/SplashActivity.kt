package com.projectbmi.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        // Delay transition to MainActivity by 2 seconds
        Handler().postDelayed({
            // Start MainActivity after the delay
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Close SplashActivity to prevent it from being in the back stack
        }, 2000) // Adjust the delay as necessary
    }
}
