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
    }
}