package com.projectbmi.bmicalculator.model

import androidx.annotation.ColorRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projectbmi.bmicalculator.R

class bmiViewModel:ViewModel() {



    //bmi Live data
    private val _bmidisplay = MutableLiveData<Float>()
    val bmidisplay: LiveData<Float> get() = _bmidisplay


    //color live data

    private val _bmiColor = MutableLiveData<Int>()
    val bmiColor: LiveData<Int> get() = _bmiColor



    //weight Live data
    private val _weightdisplay = MutableLiveData<Float>()
    val weightdisplay: LiveData<Float> get() = _weightdisplay


    //weight range
    private val _weightRange=MutableLiveData<String>()
    val weightRange:LiveData<String> get() = _weightRange

    //height Live data
    private val _heightdisplay = MutableLiveData<Float>()
    val heightdisplay: LiveData<Float> get() = _heightdisplay

    //age Live data
    private val _agedisplay = MutableLiveData<Float>()
    val agedisplay: LiveData<Float> get() = _agedisplay

    //gender Live data
    private val _genderdisplay = MutableLiveData<String>()
    val genderdisplay: LiveData<String> get() = _genderdisplay




    init {
        _bmidisplay.value = 0F
        _heightdisplay.value=0F
        _weightdisplay.value=0F
        _agedisplay.value=0F
        _genderdisplay.value= 0F.toString()
        _weightRange.value= 0F.toString()
    }







    fun calculateBmi(weight: Float,height: Float){

        val heightMetres=height/100  //convert the height to metres

        val bmi=weight/(heightMetres*heightMetres)

        _bmidisplay.value=bmi
        _bmiColor.value=getBMIColor(bmi)

    }


//display bmi with colors that are relevant
    @ColorRes
    private fun getBMIColor(bmi: Float): Int {
        return when {
            bmi < 18.5 -> R.color.blue    // Underweight
            bmi in 18.5..24.9 -> R.color.green   // Normal weight
            bmi in 25.0..29.9 -> R.color.yellow  // Overweight
            bmi >= 30.0 -> R.color.red     // Obesity
            else -> R.color.black          // Default case (in case of any unforeseen error)
        }
    }




    fun weightDisplay(weight:Float){
        _weightdisplay.value=weight
    }

    fun heightDisplay(height:Float){
        _heightdisplay.value=height
    }


    fun ageDisplay(age:Float){
        _agedisplay.value=age
    }


    fun genderDisplay(gender: String){
        _genderdisplay.value=gender

    }


    //function to display relevant weights according to the height

    fun healthyWeightHeight(height: Int,gender: String){
        val weightRange: Pair<Int,Int> =when(gender.lowercase()){
            "male" -> when(height){
                150 -> 45 to 56
                155 -> 49 to 61
                160 -> 52 to 66
                165 -> 55 to 70
                170 -> 58 to 75
                175 -> 62 to 79
                180 -> 65 to 84
                185 -> 68 to 89
                190 -> 72 to 94
                195 -> 76 to 98
                200 -> 79 to 103
                else -> return _weightRange.postValue("Height not in range")

            }

            "female"->when(height){


                150 -> 42 to 53
                155 -> 45 to 57
                160 -> 49 to 62
                165 -> 52 to 66
                170 -> 55 to 71
                175 -> 59 to 75
                180 -> 63 to 80
                185 -> 66 to 85
                190 -> 70 to 90
                195 -> 74 to 95
                200 -> 78 to 99
                else -> return _weightRange.postValue("Height not in range")
            }
           else -> return _weightRange.postValue("Invalid gender")
        }
        _weightRange.postValue("Healthy weight range for $gender at $height cm is ${weightRange.first} to ${weightRange.second} kg")


    }







}