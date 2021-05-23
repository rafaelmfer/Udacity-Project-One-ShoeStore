package com.udacity.shoestore.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class FragLogin : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            mbtLogin.setOnClickListener {
                directionToFragWelcome()
            }
            mbtLoginExistingAccount.setOnClickListener {
                directionToFragWelcome()
            }
        }
    }

    private fun directionToFragWelcome() {
        findNavController().navigate(FragLoginDirections.actionFragLoginToFragWelcome())
    }
}