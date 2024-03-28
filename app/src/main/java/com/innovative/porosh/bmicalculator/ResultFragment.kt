package com.innovative.porosh.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.innovative.porosh.bmicalculator.databinding.FragmentResultBinding
import com.innovative.porosh.bmicalculator.viewModels.BmiViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: BmiViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)

        binding = FragmentResultBinding.inflate(inflater,container,false)

        binding.bmiScoreTxt.text = String.format("%.2f",viewModel.bmi)
        binding.categoryTxt.text = viewModel.category

        return binding.root
    }

}
