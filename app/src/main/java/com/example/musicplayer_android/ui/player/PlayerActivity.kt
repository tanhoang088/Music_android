package com.example.musicplayer_android.ui.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer_android.R

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PlayerFragment.newInstance())
                .commitNow()
        }
    }
}