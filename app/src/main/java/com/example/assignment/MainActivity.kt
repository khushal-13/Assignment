package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewAllProducts = findViewById<Button>(R.id.viewAllProducts)
        viewAllProducts.setOnClickListener {
            startActivity(Intent(this, Products::class.java))
            finish()
        }
    }
}