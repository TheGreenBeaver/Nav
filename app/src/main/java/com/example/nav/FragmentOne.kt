package com.example.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.nav.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentOneBinding>(
            inflater,
            R.layout.fragment_one,
            container,
            false
        )

        binding.firstToSecondBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentTwo)
        }

        binding.playGame1Btn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentGame)
        }

        return binding.root
    }
}