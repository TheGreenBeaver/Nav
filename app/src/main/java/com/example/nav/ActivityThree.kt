package com.example.nav

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        val toFirstBtn = findViewById<Button>(R.id.third_to_first_btn)
        toFirstBtn.setOnClickListener {
            setResult(RequestCodes.THIRD_TO_FIRST.getValue())
            finish()
        }

        val toSecondBtn = findViewById<Button>(R.id.third_to_second_btn)
        toSecondBtn.setOnClickListener {
            finish()
        }

        val toAboutNav = findViewById<View>(R.id.navigation_about)
        toAboutNav.setOnClickListener {
            startActivity(Intent(this, ActivityAbout::class.java))
        }
    }
}