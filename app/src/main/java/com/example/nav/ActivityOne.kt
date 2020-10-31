package com.example.nav

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class ActivityOne : AbstractBottomNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_one)
        super.onCreate(savedInstanceState)

        val toSecondBtn = findViewById<Button>(R.id.first_to_second_btn)
        toSecondBtn.setOnClickListener {
            startActivity(Intent(this, ActivityTwo::class.java))
        }
    }
}