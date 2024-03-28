package com.innovative.porosh.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.innovative.porosh.bmicalculator.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.btnCalculate.setOnClickListener { btn ->
            val weight = binding.etWeight.text.toString().toDouble()
            val height = binding.etHeight.text.toString().toDouble()

            val bmi = weight/(height * height)
            //Toast.makeText(activity,"BMI score: $bmi",Toast.LENGTH_LONG).show()

            val bundle = bundleOf("score" to bmi)
            findNavController().navigate(R.id.result_action,bundle)
        }

        return binding.root
    }

}