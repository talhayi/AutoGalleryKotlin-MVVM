package com.example.autogallerykotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autogallerykotlin.adapter.AdvertisesAdapter
import com.example.autogallerykotlin.adapter.OnItemClickListener
import com.example.autogallerykotlin.databinding.FragmentAdvertisesBinding
import com.example.autogallerykotlin.viewmodel.AdvertisesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdvertisesFragment : Fragment() {

    private var _binding: FragmentAdvertisesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AdvertisesViewModel by viewModels()
    private lateinit var advertisesAdapter: AdvertisesAdapter
    private var advertId=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAdvertisesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRV()
        advertisesRequest()
        advertises()
    }
    private fun advertises(){
        viewModel.advertises.observe(viewLifecycleOwner){advertisesResponse->
            advertisesResponse.let {
                if (it[0].count != null){
                    advertisesAdapter.advertises =  advertisesResponse
                    advertisesAdapter.setOnItemClickListener(object : OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            advertId = advertisesResponse[position].advertId.toString()
                            findNavController().navigate(AdvertisesFragmentDirections.actionAdvertsFragmentToAdvertiseDetailFragment(advertId))
                        }
                    })
                }
            }
        }
    }
    private fun advertisesRequest(){
        viewModel.getAdvertises()
    }
    private fun setUpRV(){
        advertisesAdapter = AdvertisesAdapter()
        binding.advertisesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = advertisesAdapter

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}