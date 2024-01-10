package com.example.myuni

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class UniversityDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.university_details)

        val img = findViewById<ImageView>(R.id.universityImg)
        val uniHeading = findViewById<TextView>(R.id.universityHeading)
        val uniDetails = findViewById<TextView>(R.id.universityDetails)

        val universityName = intent.getStringExtra("universityName")
        val universityImage = intent.getIntExtra("universityImage",R.drawable.img1)
        val universityDetails = intent.getStringExtra("universityDetails")

        img.setImageResource(universityImage)
        uniHeading.text = universityName
        uniDetails.text = universityDetails
    }
}

