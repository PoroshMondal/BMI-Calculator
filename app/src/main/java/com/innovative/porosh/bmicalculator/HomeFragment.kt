package com.innovative.porosh.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var weightET: EditText
    private lateinit var heightET: EditText
    private lateinit var calculateBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        weightET = view.findViewById(R.id.etWeight)
        heightET = view.findViewById(R.id.etHeight)
        calculateBtn = view.findViewById(R.id.btnCalculate)
        calculateBtn.setOnClickListener { btn ->
            val weight = weightET.text.toString().toDouble()
            val height = heightET.text.toString().toDouble()

            val bmi = weight/(height * height)
            //Toast.makeText(activity,"BMI score: $bmi",Toast.LENGTH_LONG).show()

            val bundle = bundleOf("score" to bmi)
            findNavController().navigate(R.id.result_action,bundle)
        }

        return view
    }

}