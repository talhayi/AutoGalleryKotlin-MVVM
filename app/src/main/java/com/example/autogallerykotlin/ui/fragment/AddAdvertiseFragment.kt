package com.example.autogallerykotlin.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.FragmentAddAdvertiseBinding
import com.example.autogallerykotlin.ui.view.MainActivity

class AddAdvertiseFragment : Fragment() {

    private var _binding: FragmentAddAdvertiseBinding? = null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddAdvertiseBinding.inflate(inflater,container,false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.ilanBasliILinearLayout.setOnClickListener {
            Toast.makeText(requireContext(), "clicked", Toast.LENGTH_SHORT).show()
        }
/*
        binding.addAdvertiseButton.setOnClickListener {

            activity?.let{
                val intent = Intent (it, MainActivity::class.java)
                it.startActivity(intent)
            }
*/
/*

            val action = AddAdvertiseFragmentDirections.actionAddAdvertiseFragmentToAdvertsFragment()
            Navigation.findNavController(view).navigate(action)
        }*/


    }
}