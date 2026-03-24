package com.example.assignment2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity that displays detailed information for a single course.
 * Receives course data via Intent extras (code, name, description).
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailCode = findViewById<TextView>(R.id.tvDetailCode)
        val tvDetailName = findViewById<TextView>(R.id.tvDetailName)
        val tvDetailDescription = findViewById<TextView>(R.id.tvDetailDescription)

        // Retrieve data from Intent extras.
        val code = intent.getStringExtra("CODE") ?: "Unknown"
        val name = intent.getStringExtra("NAME") ?: "Unknown"
        val description = intent.getStringExtra("DESCRIPTION") ?: "No description available."

        // Display the data.
        tvDetailCode.text = code
        tvDetailName.text = name
        tvDetailDescription.text = description
    }
}
