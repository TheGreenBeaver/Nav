package com.example.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.nav.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentThreeBinding>(
            inflater,
            R.layout.fragment_three,
            container,
            false
        )

        binding.thirdToSecondBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigateUp()
        }

        binding.thirdToFirstBtn.setOnClickListener { view ->
            Navigation.findNavController(view).popBackStack(R.id.fragmentOne, false)
        }

        binding.playGame3Btn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentThree_to_fragmentGame)
        }

        return binding.root
    }
}