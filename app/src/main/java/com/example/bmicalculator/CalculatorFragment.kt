package com.example.bmicalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bmicalculator.model.bmiViewModel
import java.lang.NumberFormatException


/**
 * A simple [Fragment] subclass.
 * Use the [CalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculatorFragment : Fragment() {


    private lateinit var weightInput:EditText
    private lateinit var heightInput:EditText
    private lateinit var ageInput:EditText
    private lateinit var nextBtn:Button
    private lateinit var computeBtn:Button

    private lateinit var radioGroup: RadioGroup


    private val counterViewModel: bmiViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_calculator, container, false)
        weightInput=view.findViewById(R.id.weightinput)
        heightInput=view.findViewById(R.id.heightinput)
        ageInput=view.findViewById(R.id.et_age)
        computeBtn=view.findViewById(R.id.bmi_Calculate)
        nextBtn=view.findViewById(R.id.button_next)

        radioGroup=view.findViewById(R.id.rg_gender)//initialize the radio group




        computeBtn.setOnClickListener(){
            takeMeasurements()
            genderInput()
            ageInput()
            getHeightGender()
            findNavController().navigate(R.id.action_calculatorFragment2_to_resultDisplay2)
        }





        nextBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_calculatorFragment2_to_healthyDietTipsFragment2)
        }

        return view
    }


    fun takeMeasurements() {
        val weight = weightInput.text.toString()
        val height = heightInput.text.toString()

        if (weight.isEmpty() || height.isEmpty()) {
            // Handle empty fields
            showErrorMessage("Please fill in both weight and height fields.")
            return
        }

        try {
            // Convert the weights into float
            val weightConv = weight.toFloat()
            val heightConv = height.toFloat()

            if (weightConv <= 0 || heightConv <= 0) {
                showErrorMessage("Weight and height must be positive numbers.")
                return
            }

            counterViewModel.calculateBmi(weightConv, heightConv)

            // Display weight to the live data
            counterViewModel.weightDisplay(weightConv)

            // Display height to the live data
            counterViewModel.heightDisplay(heightConv)
        } catch (e: NumberFormatException) {
            showErrorMessage("Please enter valid numbers for weight and height.")
        }
    }


    private fun showErrorMessage(message: String) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }









    fun ageInput() {
        val age = ageInput.text.toString()
        if (age.isEmpty()) {
            showErrorMessage("Please enter your age.")
            return
        }
        try {
            val ageConv = age.toFloat()
            if (ageConv <= 0) {
                showErrorMessage("Age must be a positive number.")
                return
            }
            counterViewModel.ageDisplay(ageConv)
        } catch (e: NumberFormatException) {
            showErrorMessage("Please enter a valid number for age.")
        }
    }



    //function to take gender
    fun genderInput(){
        val genderChecked=radioGroup.checkedRadioButtonId //Get the ID of the selected RadioButton

        if(genderChecked != -1){ //Check if a RadioButton is selected
            val selectedRadioButton = view?.findViewById<RadioButton>(genderChecked)//Find the selected RadioButton
            val selectedGender = selectedRadioButton?.text.toString() //Get the text of the selected RadioButton

            counterViewModel.genderDisplay(selectedGender)




        }  else {
                Log.d("GenderInput", "No gender selected")

        }


    }

    //function to capture height and gender
    fun getHeightGender() {
        try {
            // Get height from input field and handle potential number format errors
            val heightText = heightInput.text.toString().trim()
            if (heightText.isEmpty()) {
                Log.e("HeightInput", "Height input is empty")

                return
            }

            // Attempt to convert height to an integer
            val heightTaken = heightText.toIntOrNull()
            if (heightTaken == null) {
                Log.e("HeightInput", "Height input is not a valid number")

                return
            }

            // Get the ID of the selected RadioButton from the RadioGroup
            val genderChecked = radioGroup.checkedRadioButtonId

            // Initialize the selectedGender variable
            var selectedGender = ""

            if (genderChecked != -1) { // Check if a RadioButton is selected
                // Find the selected RadioButton using the ID
                val selectedRadioButton = view?.findViewById<RadioButton>(genderChecked)
                selectedGender = selectedRadioButton?.text.toString()
            } else {
                Log.d("GenderInput", "No gender selected")

                return
            }

            // Call the ViewModel method with height and selected gender
            counterViewModel.healthyWeightHeight(heightTaken, selectedGender)

        } catch (e: Exception) {
            // Handle any unexpected exceptions
            Log.e("GetHeightGenderError", "An error occurred: ${e.message}", e)

        }
    }






}