package com.example.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.nav.databinding.FragmentEndGameBinding

class FragmentEndGame : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndGameBinding>(
            inflater,
            R.layout.fragment_end_game,
            container,
            false
        )

        binding.endgameToFirstBtn.setOnClickListener { view ->
            Navigation.findNavController(view).popBackStack(R.id.fragmentOne, false)
        }

        binding.restartBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentEndGame_to_fragmentGame)
        }

        binding.endgameToSecondBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentEndGame_to_fragmentTwo)
        }

        binding.endgameToThirdBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentEndGame_to_fragmentThree)
        }

        return binding.root
    }
}