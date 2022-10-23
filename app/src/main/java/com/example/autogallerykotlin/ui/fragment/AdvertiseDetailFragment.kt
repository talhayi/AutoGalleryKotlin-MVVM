package com.example.autogallerykotlin.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.autogallerykotlin.databinding.FragmentAdvertiseDetailBinding
import com.example.autogallerykotlin.viewmodel.AdvertiseDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdvertiseDetailFragment : Fragment() {

    private var _binding: FragmentAdvertiseDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AdvertiseDetailViewModel by viewModels()
    private var advertId=""

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
        advertiseDetailRequest()
        advertiseDetail()
    }

    @SuppressLint("SetTextI18n")
    private fun advertiseDetail(){

        viewModel.advertiseDetail.observe(viewLifecycleOwner){advertiseDetail->
            if (advertiseDetail.isSuccessful){

                val name = advertiseDetail.body()?.name.toString()
                val surname= advertiseDetail.body()?.surname.toString()
                if (advertiseDetail!=null){
                    binding.apply {

                        advertiseDetailTitleTV.text = advertiseDetail.body()?.advert_title.toString()
                        advertiseDetailNameTV.text = "$name $surname"
                        advertiseDetailAddressTV.text = advertiseDetail.body()?.address.toString()
                        advertiseDetailPriceTV.text = advertiseDetail.body()?.price.toString()
                        advertiseDetailBrandTV.text = advertiseDetail.body()?.brand.toString()
                        advertiseDetailSerialTV.text = advertiseDetail.body()?.serial.toString()
                        advertiseDetailModelTV.text = advertiseDetail.body()?.model.toString()
                        advertiseDetailYearTV.text = advertiseDetail.body()?.year.toString()
                        advertiseDetailFuelTV.text = advertiseDetail.body()?.fuel.toString()
                        advertiseDetailGearTV.text = advertiseDetail.body()?.gear.toString()
                        advertiseDetailVehicleStatusTV.text = advertiseDetail.body()?.vehicleStatus.toString()
                        advertiseDetailKmTV.text = advertiseDetail.body()?.km.toString()
                        advertiseDetailCaseTypeTV.text = advertiseDetail.body()?.caseType.toString()
                        advertiseDetailMotorPowerTV.text = advertiseDetail.body()?.motorPower.toString()
                        advertiseDetailMotorCapacityTV.text = advertiseDetail.body()?.motorCapacity.toString()
                        advertiseDetailTractionTV.text = advertiseDetail.body()?.traction.toString()
                        advertiseDetailColorTV.text = advertiseDetail.body()?.color.toString()
                        advertiseDetailGuaranteeTV.text = advertiseDetail.body()?.guarantee.toString()
                        advertiseDetailSwapTV.text = advertiseDetail.body()?.swap.toString()
                        advertiseDetailPhoneNumberTV.text = advertiseDetail.body()?.phoneNumber.toString()

                    }
                }


            }

        }
    }

    private fun advertiseDetailRequest(){

        arguments?.let {
            advertId = AdvertiseDetailFragmentArgs.fromBundle(it).advertId
        }

        viewModel.getAdvertiseDetail(advertId)
    }
}