package com.example.autogallerykotlin.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.text.InputFilter
import android.view.*
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.FragmentAddAdvertiseBinding
import com.example.autogallerykotlin.ui.MoneyTextWatcher
import com.example.autogallerykotlin.viewmodel.AddAdvertiseViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class AddAdvertiseFragment : Fragment() {
    private var _binding: FragmentAddAdvertiseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddAdvertiseViewModel by viewModels()
    private lateinit var alertDialog: MaterialAlertDialogBuilder
    private var userId=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddAdvertiseBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        advertiseTitle()
        explanation()
        price()
        address()
        brand()
        serial()
        model()
        year()
        fuel()
        gear()
        vehicleStatus()
        km()
        caseType()
        motorPower()
        motorCapacity()
        traction()
        color()
        guarantee()
        swap()
        phoneNumber()
        addAdvertise()
        addAdvertiseRequest()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun alertDialogBackground(dialogBuilder: MaterialAlertDialogBuilder) {
        val drawableResId = R.drawable.background_alert_dialog
        val backgroundDrawable = resources.getDrawable(drawableResId, null)
        dialogBuilder.background = backgroundDrawable
    }
    //DarkMode control
    private fun isDarkMode(): Boolean {
        val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES
    }
    private fun addAdvertiseRequest(){
        binding.addAdvertiseNextButton.setOnClickListener {
            val sharedPreferences =
                this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
            userId = sharedPreferences?.getString("users_id", null)!!
            val advertTitle = binding.advertiseTitleTextView.text.toString().trim()
            val explanation = binding.explanationTextView.text.toString().trim()
            val price = binding.priceTextView.text.toString().trim()
            val address = binding.addressTextView.text.toString().trim()
            val brand = binding.brandTextView.text.toString().trim()
            val serial = binding.serialTextView.text.toString().trim()
            val model = binding.modelTextView.text.toString().trim()
            val year = binding.yearTextView.text.toString().trim()
            val fuel = binding.fuelTextView.text.toString().trim()
            val gear = binding.gearTextView.text.toString().trim()
            val vehicleStatus = binding.vehicleStatusTextView.text.toString().trim()
            val km = binding.kmTextView.text.toString().trim()
            val caseType = binding.caseTypeTextView.text.toString().trim()
            val motorPower = binding.motorPowerTextView.text.toString().trim()
            val motorCapacity = binding.motorCapacityTextView.text.toString().trim()
            val traction = binding.tractionTextView.text.toString().trim()
            val color = binding.colorTextView.text.toString().trim()
            val guarantee = binding.guaranteeTextView.text.toString().trim()
            val swap = binding.swapTextView.text.toString().trim()
            val phoneNumber = binding.phoneNumberTextView.text.toString().trim()

            viewModel.addAdvertise(
                userId, advertTitle, explanation,
                price, address, brand,
                serial, model, year,
                fuel, gear, vehicleStatus,
                km, caseType, motorPower,
                motorCapacity, traction, color,
                guarantee, swap, phoneNumber,
            )
        }
    }
    private fun addAdvertise(){
        viewModel.addAdvertise.observe(viewLifecycleOwner) { addAdvertiseResult ->
            if (addAdvertiseResult.isSuccessful) {
                if (addAdvertiseResult.body()?.success == true) {
                    val advertId = addAdvertiseResult.body()!!.advertId.toString()
                    Toast.makeText(requireContext(), "İlan yayınlandııııı", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(AddAdvertiseFragmentDirections.actionAddAdvertiseFragmentToUploadImagesFragment(advertId))
                } else {
                    Toast.makeText(requireContext(), addAdvertiseResult.body()?.result, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "not isSuccessful", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    findNavController().navigate(AddAdvertiseFragmentDirections.actionAddAdvertiseFragmentToAdvertsFragment())
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }
    private fun advertiseTitle() {
        binding.advertiseTitleLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val advertiseTitleDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.advertiseTitleTextView.text = advertiseTitleDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun explanation() {
        binding.explanationLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            val explanationDialog = mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText)
            val oldMaxLength = explanationDialog.filters.firstOrNull { it is InputFilter.LengthFilter } as? InputFilter.LengthFilter
            explanationDialog.filters = explanationDialog.filters.filterNot { it is InputFilter.LengthFilter }.toTypedArray()
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Açıklama"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                binding.explanationTextView.text = explanationDialog.text.toString().trim()
                oldMaxLength?.let {
                    explanationDialog.filters = explanationDialog.filters.plus(it)
                }
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun price() {
        binding.priceLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.price_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            val priceDialog = mDialogView.findViewById<EditText>(R.id.priceAlertDialogEditText)
            priceDialog.addTextChangedListener(MoneyTextWatcher(mDialogView.findViewById(R.id.priceAlertDialogEditText)))
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val formattedPrice = formatPrice(MoneyTextWatcher.parseCurrencyValue(priceDialog.text.toString()).toString())
                binding.priceTextView.text = "$formattedPrice TL"
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun address() {
        binding.addressLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.address_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val city =
                    mDialogView.findViewById<TextInputEditText>(R.id.alertDialogCityEditDText).text.toString()
                        .trim()
                val district =
                    mDialogView.findViewById<TextInputEditText>(R.id.alertDialogDistrictEditText).text.toString()
                        .trim()
                val neighborhood =
                    mDialogView.findViewById<TextInputEditText>(R.id.alertDialogNeighborhoodEditText).text.toString()
                        .trim()
                binding.addressTextView.text = "$city, $district, $neighborhood"
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun brand() {
        binding.brandLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Marka"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val brandDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.brandTextView.text = brandDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun serial() {
        binding.serialLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Seri"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val serialDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.serialTextView.text = serialDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun model() {
        binding.modelLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Model"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val modelDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.modelTextView.text = modelDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun year() {
        binding.yearLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.number_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Yıl"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val yearDialog =
                    mDialogView.findViewById<EditText>(R.id.numberAlertDialogEditText).text.toString()
                        .trim()
                binding.yearTextView.text = yearDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun fuel() {
        binding.fuelLinearLayout.setOnClickListener {
            val fuels = resources.getStringArray(R.array.fuels)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, fuels)
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.fuel_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteFuelTextView)
                .setAdapter(arrayAdapter)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val fuelDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteFuelTextView).text.toString()
                binding.fuelTextView.text = fuelDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun gear() {
        binding.gearLinearLayout.setOnClickListener {
            val gears = resources.getStringArray(R.array.gears)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, gears)
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.gear_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGearTextView)
                .setAdapter(arrayAdapter)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val gearDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGearTextView).text.toString()
                binding.gearTextView.text = gearDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun vehicleStatus() {
        binding.vehicleStatusLinearLayout.setOnClickListener {
            val vehicleStatus = resources.getStringArray(R.array.vehicleStatus)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, vehicleStatus)
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.vehicle_status_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteVehicleStatusTextView)
                .setAdapter(arrayAdapter)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val vehicleStatusDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteVehicleStatusTextView).text.toString()
                binding.vehicleStatusTextView.text = vehicleStatusDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun km() {
        binding.kmLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.number_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "KM"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val vehicleStatusDialog =
                    mDialogView.findViewById<EditText>(R.id.numberAlertDialogEditText).text.toString()
                        .trim()
                binding.kmTextView.text = "$vehicleStatusDialog KM"
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun caseType() {
        binding.caseTypeLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Kasa Tipi"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val caseTypeDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.caseTypeTextView.text = caseTypeDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun motorPower() {
        binding.motorPowerLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Motor Gücü"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val motorPowerDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.motorPowerTextView.text = motorPowerDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun motorCapacity() {
        binding.motorCapacityLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Motor Hacmi"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val motorCapacityDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.motorCapacityTextView.text = motorCapacityDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun traction() {
        binding.tractionLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<TextView>(R.id.textView).text = "Çekiş"
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val tractionDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.tractionTextView.text = tractionDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun color() {
        binding.colorLinearLayout.setOnClickListener {
            val colors = resources.getStringArray(R.array.colors)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, colors)
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.color_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteColorTextView)
                .setAdapter(arrayAdapter)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val colorDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteColorTextView).text.toString()
                binding.colorTextView.text = colorDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun guarantee() {
        binding.guaranteeLinearLayout.setOnClickListener {
            val guarantees = resources.getStringArray(R.array.guarantees)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, guarantees)
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.guatantee_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGuaranteeTextView)
                .setAdapter(arrayAdapter)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val guaranteeDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGuaranteeTextView).text.toString()
                binding.guaranteeTextView.text = guaranteeDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun swap() {
        binding.swapLinearLayout.setOnClickListener {
            val guarantees = resources.getStringArray(R.array.guarantees)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, guarantees)
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.swap_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteSwapTextView)
                .setAdapter(arrayAdapter)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val swapDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteSwapTextView).text.toString()
                binding.swapTextView.text = swapDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }
    private fun phoneNumber() {
        binding.phoneNumberLinearLayout.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.phone_number_alert_dialog, null)
            val alertDialogStyle = R.style.AlertDialogStyle
            alertDialog = MaterialAlertDialogBuilder(ContextThemeWrapper(requireContext(), alertDialogStyle)).setView(mDialogView)
            alertDialog.setNegativeButton("İPTAL") { _, _ -> }
            alertDialog.setPositiveButton("TAMAM") { _, _ ->
                val phoneNumberDialog =
                    mDialogView.findViewById<EditText>(R.id.phoneNumberAlertDialogEditText).text.toString()
                        .trim()
                binding.phoneNumberTextView.text = phoneNumberDialog
            }
            alertDialogBackground(alertDialog)
            alertDialog.show()
        }
    }

    private fun formatPrice(input: String): String {
        return if (input.isNotEmpty()) {
            val reversedInput = input.reversed()
            val stringBuilder = StringBuilder()
            for (i in reversedInput.indices) {
                if (i % 3 == 0 && i != 0) {
                    stringBuilder.append('.')
                }
                stringBuilder.append(reversedInput[i])
            }
            stringBuilder.reverse().toString()
        } else {
            input
        }
    }
}