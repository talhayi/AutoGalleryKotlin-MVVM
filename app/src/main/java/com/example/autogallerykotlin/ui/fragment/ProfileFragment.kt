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
import com.example.autogallerykotlin.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()
    private var userId = ""
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
        binding.updateEmailButton.setOnClickListener {
            binding.updatePasswordButton.visibility = View.GONE
            binding.updatePhoneNumberButton.visibility = View.GONE
            binding.updateAddressButton.visibility = View.GONE
            binding.emailLinearLayout.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.updatePasswordButton.setOnClickListener {
            binding.updateEmailButton.visibility = View.GONE
            binding.updatePhoneNumberButton.visibility = View.GONE
            binding.updateAddressButton.visibility = View.GONE
            binding.passwordLinearLayout.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.updatePhoneNumberButton.setOnClickListener {
            binding.updatePasswordButton.visibility = View.GONE
            binding.updateEmailButton.visibility = View.GONE
            binding.updateAddressButton.visibility = View.GONE
            binding.phoneNumberLinearLayout.visibility = View.VISIBLE
            binding.updateProfileButton.visibility = View.VISIBLE
            binding.cancelProfileButton.visibility = View.VISIBLE
        }

        binding.updateAddressButton.setOnClickListener {
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
        }
    }

    private fun updateProfile() {
        viewModel.updateProfileEmail.observe(viewLifecycleOwner) { updateProfileEmail ->
            if (updateProfileEmail.isSuccessful) {
                if (updateProfileEmail.body()?.success == true) {
                    viewModel.getInformationProfile(userId)
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
            if (updateProfilePassword.isSuccessful) {
                if (updateProfilePassword.body()?.success == true) {
                    viewModel.getInformationProfile(userId)
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
    }
    private fun updateProfileRequest() {
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
            viewModel.getUpdateProfileEmail(
                userId,
                email,
             /*   password,
                againPassword,
                phoneNumber,
                city,
                district,
                neighborhood*/
            )

            viewModel.getUpdateProfilePassword(
                userId,
                password,
                againPassword,
                )
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
}