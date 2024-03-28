package com.innovative.porosh.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.innovative.porosh.bmicalculator.databinding.FragmentHomeBinding
import com.innovative.porosh.bmicalculator.viewModels.BmiViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: BmiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.btnCalculate.setOnClickListener { btn ->
            val weight = binding.etWeight.text.toString().toDouble()
            val height = binding.etHeight.text.toString().toDouble()

            viewModel.calculateBmi(weight,height)

            findNavController().navigate(R.id.result_action)
        }

        return binding.root
    }

}