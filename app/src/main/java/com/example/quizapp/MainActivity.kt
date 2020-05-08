package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testModusBtn = findViewById<Button>(R.id.Testmodusbtn)
        testModusBtn.setOnClickListener{
            val intent = Intent(this, WissenLevelAcitivity::class.java)
            startActivity(intent)
        }

        val lernModusBtn = findViewById<Button>(R.id.Lernmodusbtn)
        lernModusBtn.setOnClickListener{
            val intent = Intent(this, WissenLevelAcitivity::class.java)
            startActivity(intent)
        }
    }
}
