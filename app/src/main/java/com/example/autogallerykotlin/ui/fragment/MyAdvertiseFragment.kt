package com.example.autogallerykotlin.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autogallerykotlin.R
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

    private lateinit var alertDialog: AlertDialog.Builder




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentMyAdvertiseBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sharedPreferences =
            this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
        val userId = sharedPreferences?.getString("users_id", null)!!
        viewModel.getMyAdvertise(userId)

        viewModel.myAdvertise.observe(viewLifecycleOwner){myAdvertiseResponse->
            myAdvertiseResponse.let {
                myAdvertiseAdapter.myAdvertise = myAdvertiseResponse
            }
        }
        setUpRV()
        deleteMyAdvertise()



    }


    private fun deleteMyAdvertise() {

        myAdvertiseAdapter.setOnItemClickListener(object : MyAdvertiseAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(requireContext(), "Tıklandı $position", Toast.LENGTH_SHORT).show()
            }

        })




    }

    private fun setUpRV(){

        myAdvertiseAdapter = MyAdvertiseAdapter()
        binding.myAdvertiseRecyclerView.apply {

            layoutManager = LinearLayoutManager(requireContext())

            adapter = myAdvertiseAdapter

        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}