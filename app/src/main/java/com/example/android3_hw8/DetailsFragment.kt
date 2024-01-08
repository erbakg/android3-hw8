package com.example.android3_hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.android3_hw8.databinding.FragmentDetailsBinding
import com.example.android3_hw8.databinding.FragmentMainBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val character = arguments?.let { getSerializable(it, CONSTANTS.CHARACTER, Character::class.java) }
        binding.tvCharacterName.text =character?.name
        binding.tvCharacterStatus.text = character?.status
        context?.let {
            Glide.with(it)
                .load(character?.image)
                .into(binding.ivCharacter)
        }

    }
}