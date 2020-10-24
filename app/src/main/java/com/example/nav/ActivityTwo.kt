package com.example.nav

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val toFirstBtn = findViewById<Button>(R.id.second_to_first_btn)
        toFirstBtn.setOnClickListener {
            finish()
        }

        val toThirdBtn = findViewById<Button>(R.id.second_to_third_btn)
        toThirdBtn.setOnClickListener {
            startActivity(Intent(this, ActivityThree::class.java))
        }

        val toAboutNav = findViewById<View>(R.id.navigation_about)
        toAboutNav.setOnClickListener {
            startActivity(Intent(this, ActivityAbout::class.java))
        }
    }
}