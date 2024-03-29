package com.innovative.porosh.bmicalculator.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innovative.porosh.bmicalculator.ResultFragment

/*
* This is a separator class for View and Model
* Here we will write all Business logic
* Used Live Data functionality to observe the data changes in View or UI
* */
class BmiViewModel: ViewModel() {

    var bmi: MutableLiveData<Double> = MutableLiveData()
    var category: MutableLiveData<String> = MutableLiveData()

    public fun calculateBmi(weight: Double, height: Double){
        bmi.value = weight/(height * height)

        category.value = when(String.format("%.1f",bmi.value).toDouble()){
            in 0.0 .. 18.4 -> UNDER_WEIGHT
            in 18.5 .. 24.9 -> NORMAL
            in 25.0 .. 29.9 -> OVER_WEIGHT
            in 30.0 .. 34.9 -> OBESITY1
            in 35.0 .. 39.9 -> OBESITY2
            else -> OBESITY3
        }

        Log.e("BMIViewModel", "${String.format("%.1f",bmi.value)}, $category")

    }

    companion object {
        const val UNDER_WEIGHT = "UNDER WEIGHT"
        const val NORMAL = "NORMAL"
        const val OVER_WEIGHT = "OVER WEIGHT"
        const val OBESITY1 = "OBESITY CLASS 1"
        const val OBESITY2 = "OBESITY CLASS 2"
        const val OBESITY3 = "OBESITY CLASS 3"
    }

}