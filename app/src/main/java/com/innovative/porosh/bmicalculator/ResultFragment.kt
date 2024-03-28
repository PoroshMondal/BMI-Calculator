package com.innovative.porosh.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultFragment : Fragment() {

    private lateinit var bmiScoreTxt: TextView
    private lateinit var categoryTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        bmiScoreTxt = view.findViewById(R.id.bmiScoreTxt)
        categoryTxt = view.findViewById(R.id.categoryTxt)

        val score = arguments?.getDouble("score")
        val formattedScore = String.format("%.2f",score)
        bmiScoreTxt.text = formattedScore

        val category = when(formattedScore.toDouble()){
            in 0.0 .. 18.4 -> UNDER_WEIGHT
            in 18.5 .. 24.9 -> NORMAL
            in 25.0 .. 29.9 -> OVER_WEIGHT
            in 30.0 .. 34.9 -> OBESITY1
            in 35.0 .. 39.9 -> OBESITY2
            else -> OBESITY3
        }

        categoryTxt.text = category

        return view
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
