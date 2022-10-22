package com.example.autogallerykotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.FragmentAdvertiseDetailBinding
import com.example.autogallerykotlin.databinding.FragmentAdvertisesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdvertiseDetailFragment : Fragment() {
//    FragmentAdvertisesBinding? = null
    private var _binding: FragmentAdvertiseDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAdvertiseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}