package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.extensions.visible

class FragInstructions : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {

            mbtNext.setOnClickListener {
                when {
                    !tvInstructionTwo.isVisible -> {
                        tvInstructionTwo.visible
                    }
                    tvInstructionTwo.isVisible && !tvInstructionThree.isVisible -> {
                        tvInstructionThree.visible
                        mbtNext.text = getString(R.string.got_it)
                    }
                    tvInstructionTwo.isVisible && tvInstructionThree.isVisible -> {

                    }
                }
            }

        }
    }
}