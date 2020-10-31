package com.example.nav

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class ActivityTwo : AbstractBottomNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_two)
        super.onCreate(savedInstanceState)

        val toFirstBtn = findViewById<Button>(R.id.second_to_first_btn)
        toFirstBtn.setOnClickListener {
            finish()
        }

        val toThirdBtn = findViewById<Button>(R.id.second_to_third_btn)
        toThirdBtn.setOnClickListener {
            startActivityForResult(
                Intent(this, ActivityThree::class.java),
                RequestCodes.THIRD_TO_FIRST.getValue()
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == resultCode) {
            finish()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}