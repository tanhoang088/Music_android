package com.example.musicplayer_android.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.musicplayer_android.MainActivity
import com.example.musicplayer_android.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            var mainActivity = Intent(this, MainActivity::class.java)
            mainActivity.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(mainActivity)
            //Do something after 100ms
        }, 5000)
    }
}