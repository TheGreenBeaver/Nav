package com.example.nav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        val toSecondBtn = findViewById<Button>(R.id.first_to_second_btn)
        toSecondBtn.setOnClickListener {
            startActivity(Intent(this, ActivityTwo::class.java))
        }

        val toAboutNav = findViewById<View>(R.id.navigation_about)
        toAboutNav.setOnClickListener {
            startActivity(Intent(this, ActivityAbout::class.java))
        }

        val toGame = findViewById<Button>(R.id.play_game_1_btn)
        toGame.setOnClickListener {
            val intent = Intent(this, ActivityGame::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
    }
}