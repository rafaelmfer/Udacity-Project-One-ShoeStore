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
        observables()
        binding.run {
            //Pass the ShoeViewModel into the binding.mainViewModel so provide communication with xml
            mainViewModel = shoeDetailViewModel
            //Make LifeCycleAware
            lifecycleOwner = this@FragShoeDetail
        }
    }

    private fun observables() {
        shoeDetailViewModel.run {
            eventCancelLiveData.observe(viewLifecycleOwner, { isCanceled ->
                if (isCanceled) {
                    navigateToFragShoeList()
                    onCancelEventComplete()
                }
            })

            eventAddShoeLiveData.observe(viewLifecycleOwner, { isAdded ->
                if (isAdded) {
                    navigateToFragShoeList()
                    onAddShoeComplete()
                }
            })
        }
    }

    private fun navigateToFragShoeList() {
        findNavController().navigate(FragShoeDetailDirections.actionFragShoeDetailToFragShoeList())
    }
}