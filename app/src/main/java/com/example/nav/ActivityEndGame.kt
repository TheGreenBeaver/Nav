package com.example.nav

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityEndGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val restartBtn = findViewById<Button>(R.id.restart_btn)
        restartBtn.setOnClickListener {
            val intent = Intent(this, ActivityGame::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        val toFirstBtn = findViewById<Button>(R.id.endgame_to_first_btn)
        toFirstBtn.setOnClickListener {
            val intent = Intent(this, ActivityOne::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val toSecondBtn = findViewById<Button>(R.id.endgame_to_second_btn)
        toSecondBtn.setOnClickListener {
            val intent = Intent(this, ActivityTwo::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val toThirdBtn = findViewById<Button>(R.id.endgame_to_third_btn)
        toThirdBtn.setOnClickListener {
            val intent = Intent(this, ActivityThree::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }
}