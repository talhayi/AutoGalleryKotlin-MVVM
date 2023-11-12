package com.example.autogallerykotlin.ui.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.autogallerykotlin.databinding.FragmentProfileBinding
import com.example.autogallerykotlin.util.UpdateProfileType
import com.example.autogallerykotlin.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()
    private var userId = ""
    private var selectedUpdateProfileType: UpdateProfileType? = null
    private var isUpdateTriggered = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        informationProfileRequest()
        informationProfile()
        updateProfileRequest()
        updateProfile()
        onButtonClickListener()

    }

    private fun onButtonClickListener(){
        binding.updateEmailButton.setOnClickListener {
            selectedUpdateProfileType = UpdateProfileType.EMAIL
            isUpdateTriggered = true
            binding.updatePasswordButton.visibility = View.GONE
            binding.updatePhoneNumberButton.visibility = View.GONE
            binding.updateAddressButton.visibility = View.GONE
            binding.emailLinearLayout.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.updatePasswordButton.setOnClickListener {
            isUpdateTriggered = true
            selectedUpdateProfileType = UpdateProfileType.PASSWORD
            binding.updateEmailButton.visibility = View.GONE
            binding.updatePhoneNumberButton.visibility = View.GONE
            binding.updateAddressButton.visibility = View.GONE
            binding.passwordLinearLayout.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.updatePhoneNumberButton.setOnClickListener {
            isUpdateTriggered = true
            selectedUpdateProfileType = UpdateProfileType.PHONE
            binding.updatePasswordButton.visibility = View.GONE
            binding.updateEmailButton.visibility = View.GONE
            binding.updateAddressButton.visibility = View.GONE
            binding.phoneNumberLinearLayout.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.updateAddressButton.setOnClickListener {
            isUpdateTriggered = true
            selectedUpdateProfileType = UpdateProfileType.ADDRESS
            binding.updatePasswordButton.visibility = View.GONE
            binding.updateEmailButton.visibility = View.GONE
            binding.updatePhoneNumberButton.visibility = View.GONE
            binding.updateCityContainer.visibility = View.VISIBLE
            binding.updateDistrictContainer.visibility = View.VISIBLE
            binding.updateNeighborhoodContainer.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.cancelProfileButton.setOnClickListener {
            binding.updateEmailButton.visibility = View.VISIBLE
            binding.updatePasswordButton.visibility = View.VISIBLE
            binding.updatePhoneNumberButton.visibility = View.VISIBLE
            binding.updateAddressButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.GONE
            binding.updateProfileButton.visibility = View.GONE
            binding.emailLinearLayout.visibility = View.GONE
            binding.passwordLinearLayout.visibility = View.GONE
            binding.phoneNumberLinearLayout.visibility = View.GONE
            binding.updateCityContainer.visibility = View.GONE
            binding.updateDistrictContainer.visibility = View.GONE
            binding.updateNeighborhoodContainer.visibility = View.GONE
            clearText()
        }
    }

    private fun updateProfile() {
        viewModel.updateProfileEmail.observe(viewLifecycleOwner) { updateProfileEmail ->
            if (updateProfileEmail.isSuccessful && isUpdateTriggered) {
                if (updateProfileEmail.body()?.success == true) {
                    //viewModel.getInformationProfile(userId)
                    Toast.makeText(
                        requireContext(),
                        updateProfileEmail.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        updateProfileEmail.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.updateProfilePassword.observe(viewLifecycleOwner) { updateProfilePassword ->
            if (updateProfilePassword.isSuccessful && isUpdateTriggered) {
                if (updateProfilePassword.body()?.success == true) {
                    Toast.makeText(
                        requireContext(),
                        updateProfilePassword.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        updateProfilePassword.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.updateProfilePhone.observe(viewLifecycleOwner) { updateProfilePhone ->
            if (updateProfilePhone.isSuccessful && isUpdateTriggered) {
                if (updateProfilePhone.body()?.success == true) {
                    Toast.makeText(
                        requireContext(),
                        updateProfilePhone.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        updateProfilePhone.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.updateProfileAddress.observe(viewLifecycleOwner) { updateProfileAddress ->
            if (updateProfileAddress.isSuccessful && isUpdateTriggered) {
                if (updateProfileAddress.body()?.success == true) {

                    Toast.makeText(
                        requireContext(),
                        updateProfileAddress.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        updateProfileAddress.body()?.result,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun updateProfileRequest() {
        //todo güncelleme isteği atıldığında profil ekranındaki kullanıcıya ait bilgiler de güncellenmeli
        binding.updateProfileButton.setOnClickListener {
            binding.updateEmailButton.visibility = View.VISIBLE
            binding.updatePasswordButton.visibility = View.VISIBLE
            binding.updatePhoneNumberButton.visibility = View.VISIBLE
            binding.updateAddressButton.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.GONE
            binding.emailLinearLayout.visibility = View.GONE
            binding.passwordLinearLayout.visibility = View.GONE
            binding.phoneNumberLinearLayout.visibility = View.GONE
            binding.updateCityContainer.visibility = View.GONE
            binding.updateDistrictContainer.visibility = View.GONE
            binding.updateNeighborhoodContainer.visibility = View.GONE
            binding.cancelProfileButton.visibility = View.GONE

            val sharedPreferences =
                this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
            userId = sharedPreferences?.getString("users_id", null)!!

            val email = binding.updateEmailET.text.toString().trim()
            val password = binding.updatePasswordET.text.toString().trim()
            val againPassword = binding.updatePasswordAgainET.text.toString().trim()
            val phoneNumber = binding.phoneNumberAlertDialogEditText.text.toString().trim()
            val city = binding.updateCityET.text.toString().trim()
            val district = binding.updateDistrictET.text.toString().trim()
            val neighborhood = binding.updateNeighborhoodET.text.toString().trim()
            when (selectedUpdateProfileType) {
                UpdateProfileType.EMAIL -> {
                    viewModel.getUpdateProfileEmail(userId, email)
                }

                UpdateProfileType.PASSWORD -> {
                    viewModel.getUpdateProfilePassword(userId, password, againPassword)
                }

                UpdateProfileType.PHONE -> {
                    viewModel.getUpdateProfilePhone(userId, phoneNumber)
                }

                UpdateProfileType.ADDRESS -> {
                    viewModel.getUpdateProfileAddress(userId, city, district, neighborhood)
                }

                else -> {
                    // Nothing
                }
            }
            clearText()
        }
    }

    private fun informationProfile() {
        viewModel.informationProfile.observe(viewLifecycleOwner) { informationProfile ->
            if (informationProfile.isSuccessful) {
                val name = informationProfile.body()?.name
                val surname = informationProfile.body()?.surname
                binding.fullNameTV.text = "$name $surname"
                binding.emailTV.text = informationProfile.body()?.email
                binding.phoneNumberTV.text = informationProfile.body()?.phoneNumber
                binding.addressTV.text = informationProfile.body()?.address
            }
        }
    }
    private fun informationProfileRequest() {
        val sharedPreferences =
            this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
        userId = sharedPreferences?.getString("users_id", null)!!
        viewModel.getInformationProfile(userId)
    }
    private fun clearText(){
        binding.updateEmailET.text!!.clear()
        binding.updatePasswordET.text!!.clear()
        binding.updatePasswordAgainET.text!!.clear()
        binding.phoneNumberAlertDialogEditText.text!!.clear()
        binding.updateCityET.text!!.clear()
        binding.updateDistrictET.text!!.clear()
        binding.updateNeighborhoodET.text!!.clear()
    }
}