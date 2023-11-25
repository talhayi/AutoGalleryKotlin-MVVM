package com.example.autogallerykotlin.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.adapter.MyAdvertiseAdapter
import com.example.autogallerykotlin.adapter.OnItemClickListener
import com.example.autogallerykotlin.data.model.MyAdvertise
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
    private var userId = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMyAdvertiseBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences =
            this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
        userId = sharedPreferences?.getString("users_id", null)!!
        setUpRV()
        myAdvertiseRequest()
        deleteMyAdvertiseRequest()
    }

    private fun deleteMyAdvertiseRequest() {
        viewModel.myAdvertise.observe(viewLifecycleOwner) { deleteMyAdvertiseList ->
            deleteMyAdvertiseList.let {
                if (it[0].count != null) {
                    myAdvertiseAdapter.myAdvertise = deleteMyAdvertiseList
                    myAdvertiseAdapter.setOnItemClickListener(object : OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            handleItemClick(deleteMyAdvertiseList[position])
                        }
                    })
                }
            }
        }
    }

    private fun handleItemClick(myAdvertise: MyAdvertise) {
        val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.delete_alert_dialog, null)
        alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)
        alertDialog.setNegativeButton("HAYIR") { _, _ -> }
        alertDialog.setPositiveButton("EVET") { _, _ ->
            viewModel.getMyAdvertise(userId,myAdvertise.advertId!!)
            Toast.makeText(requireContext(), myAdvertise.result, Toast.LENGTH_SHORT).show()
        }
        alertDialog.show()
    }

    private fun myAdvertiseRequest() {
        viewModel.getMyAdvertise(userId, "")
    }

    private fun setUpRV() {
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