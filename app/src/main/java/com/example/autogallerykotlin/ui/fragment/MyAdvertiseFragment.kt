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
import com.example.autogallerykotlin.databinding.FragmentMyAdvertiseBinding
import com.example.autogallerykotlin.viewmodel.MyAdvertiseViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notifyAll

@AndroidEntryPoint
class MyAdvertiseFragment : Fragment() {

    private var _binding: FragmentMyAdvertiseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyAdvertiseViewModel by viewModels()
    private lateinit var myAdvertiseAdapter: MyAdvertiseAdapter
    private lateinit var alertDialog: AlertDialog.Builder
    private var advertId=""
    private var userId=""

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

        myAdvertiseRequest()
        setUpRV()
        deleteMyAdvertiseRequest()
        deleteMyAdvertise()

    }

    private fun deleteMyAdvertiseRequest() {

        viewModel.myAdvertise.observe(viewLifecycleOwner) { myAdvertiseResponse ->
            myAdvertiseResponse.let {

                if (it[0].count!=null) {

                    myAdvertiseAdapter.myAdvertise = myAdvertiseResponse

                    myAdvertiseAdapter.setOnItemClickListener(object :
                        MyAdvertiseAdapter.onItemClickListener {
                        override fun onItemClick(position: Int) {

                            val mDialogView = LayoutInflater.from(requireContext())
                                .inflate(R.layout.delete_alert_dialog, null)

                            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

                            alertDialog.setNegativeButton("HAYIR") { _, _ -> }

                            alertDialog.setPositiveButton("EVET") { _, _ ->

                                advertId = myAdvertiseResponse[position].advert_id.toString()

                                //todo: notifyItemRemoved kullanınca db'den siliniyor ama uygulamadan silinmiyor
                                // myAdvertiseAdapter.notifyItemRemoved(position)

                                viewModel.getDeleteMyAdvertise(advertId)
                                myAdvertiseAdapter.notifyItemRemoved(position)

                            }

                            alertDialog.show()
                        }
                    })
                }
            }
        }
    }

    private fun deleteMyAdvertise(){

        viewModel.deleteMyAdvertise.observe(viewLifecycleOwner){deleteMyAdvertiseResponse->

            if(deleteMyAdvertiseResponse.isSuccessful){
                if (deleteMyAdvertiseResponse.body()?.success ==true){

                    Toast.makeText(requireContext(), "silindi", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(requireContext(), "silinmedi", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(), "not isSuccessful", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun myAdvertiseRequest(){
        val sharedPreferences =
            this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
        userId = sharedPreferences?.getString("users_id", null)!!
        viewModel.getMyAdvertise(userId)
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