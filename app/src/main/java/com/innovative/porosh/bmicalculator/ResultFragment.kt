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
        binding = FragmentResultBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)
        viewModel.bmi.observe(viewLifecycleOwner) { bmi ->
            binding.bmiScoreTxt.text = String.format("%.1f", bmi)
        }
        viewModel.category.observe(viewLifecycleOwner){category ->
            binding.categoryTxt.text = category
        }

        return binding.root
    }

}
