package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import java.math.BigDecimal
import android.widget.TextView
import android.widget.Toast
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //input on click listener here
        binding.bmiCalculate.setOnClickListener {
            weightCalculation()

        }
        //implement the function to enable navigation to the next activity
        binding.buttonNext.setOnClickListener{
            launchNext()
        }

    }


    fun weightCalculation(){
        val weightInput = binding.weightinput.text.toString()
        val heightInput = binding.heightinput.text.toString()

        if (weightInput.isEmpty() || heightInput.isEmpty()) {
            Toast.makeText(this, " Ensure to enter both weight and height", Toast.LENGTH_SHORT).show()
            return
        }
        try {

            //convert the weights into double
            val weight = weightInput.toDouble()
            val height = heightInput.toDouble()

            if (height == 0.0) {
                Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show()
                return
            }


            val bmi = weight / (height * height)
            //display the results against the available bmi chart
            val result = when (bmi) {

                in 0.0..18.5 -> "underweight"
                in 18.5..24.9 -> "Normal weight"
                in 25.0..29.9 -> "Overweight"
                else -> "Obese!"

            }

            binding.resultdisplay.text = "Result: $result"

        }catch (e: NumberFormatException) {
            // Handle the case where the input is not a valid number
            Toast.makeText(this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show()
        }
    }



    private fun launchNext(){
        val listIntent =Intent(this,HealthyTipsActivity::class.java)
        startActivity(listIntent)
    }




}