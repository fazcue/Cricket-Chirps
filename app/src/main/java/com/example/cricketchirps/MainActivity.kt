package com.example.cricketchirps

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var temp = 0.0

    private lateinit var etInput: EditText
    private lateinit var btnCalculateTemp: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInput = findViewById(R.id.etInput)
        btnCalculateTemp = findViewById(R.id.btnCalculateTemp)
        tvResult = findViewById(R.id.tvResult)

        btnCalculateTemp.setOnClickListener { onBtnCalculateTempClick() }
    }

    private fun calculateTemp(): Unit {
        temp = etInput.text.toString().toDouble() / 3 + 4
    }

    private fun onBtnCalculateTempClick() {
        if (etInput.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            tvResult.visibility = TextView.GONE
            return
        }

        calculateTemp()
        tvResult.text = "$temp celcius"
        tvResult.visibility = TextView.VISIBLE
    }
}