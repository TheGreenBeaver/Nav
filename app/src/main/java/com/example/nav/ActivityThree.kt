package com.example.nav

import android.os.Bundle
import android.widget.Button

class ActivityThree : AbstractBottomNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_three)
        super.onCreate(savedInstanceState)

        val toFirstBtn = findViewById<Button>(R.id.third_to_first_btn)
        toFirstBtn.setOnClickListener {
            setResult(RequestCodes.THIRD_TO_FIRST.getValue())
            finish()
        }

        val toSecondBtn = findViewById<Button>(R.id.third_to_second_btn)
        toSecondBtn.setOnClickListener {
            finish()
        }
    }
}