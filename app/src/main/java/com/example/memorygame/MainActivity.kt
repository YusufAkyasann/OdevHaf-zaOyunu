package com.example.memorygame

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun kolay(view: View?) {
        startActivity(Intent(this@MainActivity, MainActivity2::class.java))
    }
    fun zor(view: View?) {
        startActivity(Intent(this@MainActivity, MainActivity3::class.java))
    }

    }

