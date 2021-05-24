package com.udacity.shoestore.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class FragShoeDetail : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val shoeDetailViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Pass the ShoeViewModel into the binding.shoemodel so provide communication with xml
        binding.mainViewModel = shoeDetailViewModel
        //Make LifeCycleAware
        binding.lifecycleOwner = this
        binding.run {
            bindCancelButton()
            bindAddButton()
        }
    }

    private fun FragmentShoeDetailBinding.bindAddButton() {
        mbtAddShoe.setOnClickListener {
            shoeDetailViewModel.addShoe()
            findNavController().navigate(FragShoeDetailDirections.actionFragShoeDetailToFragShoeList())
        }
    }

    private fun FragmentShoeDetailBinding.bindCancelButton() {
        mbtCancel.setOnClickListener {
            findNavController().navigate(FragShoeDetailDirections.actionFragShoeDetailToFragShoeList())
        }
    }
}