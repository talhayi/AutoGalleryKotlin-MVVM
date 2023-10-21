package com.example.autogallerykotlin.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.adapter.MyFavoriteAdvertiseAdapter
import com.example.autogallerykotlin.adapter.OnItemClickListener
import com.example.autogallerykotlin.databinding.FragmentMyAdvertiseBinding
import com.example.autogallerykotlin.databinding.FragmentMyFavoritesBinding
import com.example.autogallerykotlin.viewmodel.AdvertiseDetailViewModel
import com.example.autogallerykotlin.viewmodel.MyFavoriteAdvertiseViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MyFavoritesFragment : Fragment() {
    private var _binding: FragmentMyFavoritesBinding?= null
    private val binding get() = _binding!!
    private val viewModel: MyFavoriteAdvertiseViewModel by viewModels()
    private lateinit var myFavoriteAdvertiseAdapter: MyFavoriteAdvertiseAdapter
    private var advertId=""
    private var userId=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMyFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRV()
        myFavoriteAdvertise()
        myFavoriteAdvertiseRequest()
    }

    private fun myFavoriteAdvertise(){
        viewModel.myFavoriteAdvertise.observe(viewLifecycleOwner){myFavoriteAdvertiseResponse->
            myFavoriteAdvertiseResponse.let {
                if (it[0].count!=null){
                    myFavoriteAdvertiseAdapter.myFavoriteAdvertise = myFavoriteAdvertiseResponse
                    myFavoriteAdvertiseAdapter.setOnItemClickListener(object : OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            advertId = myFavoriteAdvertiseResponse[position].advert_id.toString()
                            findNavController().navigate(MyFavoritesFragmentDirections.actionMyFavoritesFragmentToAdvertiseDetailFragment(advertId))
                        }
                    })
                }
            }
        }
    }
    private fun myFavoriteAdvertiseRequest(){
        val sharedPreferences =
            this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
        userId = sharedPreferences?.getString("users_id", null)!!
        viewModel.getMyFavoriteAdvertise(userId)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRV(){
        myFavoriteAdvertiseAdapter = MyFavoriteAdvertiseAdapter()
        binding.myFavoriteAdvertiseRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myFavoriteAdvertiseAdapter
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}