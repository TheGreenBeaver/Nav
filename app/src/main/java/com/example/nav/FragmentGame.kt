package com.example.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.nav.databinding.FragmentGameBinding

class FragmentGame : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )

        binding.pressToWinBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_fragmentGame_to_fragmentEndGame)
        }

        return binding.root
    }
}