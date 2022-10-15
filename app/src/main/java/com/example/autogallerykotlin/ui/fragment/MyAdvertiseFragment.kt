package com.example.autogallerykotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.autogallerykotlin.adapter.MyAdvertiseAdapter
import com.example.autogallerykotlin.databinding.FragmentMyAdvertiseBinding
import com.example.autogallerykotlin.viewmodel.MyAdvertiseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyAdvertiseFragment : Fragment() {

    private var _binding: FragmentMyAdvertiseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyAdvertiseViewModel by viewModels()
    private lateinit var myAdvertiseAdapter: MyAdvertiseAdapter




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentMyAdvertiseBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRV()
    }

    private fun setUpRV(){
        myAdvertiseAdapter = MyAdvertiseAdapter()
        binding.myAdvertiseRecyclerView.apply {
            layoutManager = GridLayoutManager(context,1)
            setHasFixedSize(true)
        }

        viewModel.myAdvertise.observe(viewLifecycleOwner){myAdvertiseResponse->
            myAdvertiseResponse.let {
                myAdvertiseAdapter.myAdvertise = myAdvertiseResponse
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}