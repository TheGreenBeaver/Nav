package com.example.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.nav.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTwoBinding>(
            inflater,
            R.layout.fragment_two,
            container,
            false
        )

        binding.secondToThirdBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentTwo_to_fragmentThree)
        }

        binding.secondToFirstBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigateUp()
        }

        return binding.root
    }
}