package com.example.autogallerykotlin.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.FragmentAddAdvertiseBinding
import com.example.autogallerykotlin.viewmodel.AddAdvertiseViewModel
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class AddAdvertiseFragment : Fragment() {

    private var _binding: FragmentAddAdvertiseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddAdvertiseViewModel by viewModels()

    private lateinit var alertDialog: AlertDialog.Builder

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

        val sharedPreferences =
            this.activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)



        viewModel.addAdvertise.observe(viewLifecycleOwner) { addAdvertiseResult ->
            if (addAdvertiseResult.isSuccessful) {
                if (addAdvertiseResult.body()?.success == true) {

                    val advertId = addAdvertiseResult.body()!!.advert_id.toString()

                    Toast.makeText(requireContext(), "İlan yayınlandı", Toast.LENGTH_SHORT).show()

                   findNavController().navigate(AddAdvertiseFragmentDirections.actionAddAdvertiseFragmentToUploadImagesFragment(advertId))


                } else {
                    Toast.makeText(requireContext(), "not success", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "not isSuccessful", Toast.LENGTH_SHORT).show()
            }


        }

        binding.addAdvertiseNextButton.setOnClickListener {


            val userId = sharedPreferences?.getString("users_id", null)!!
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

    private fun advertiseTitle() {
        binding.advertiseTitleLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)
            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val advertiseTitleDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()
                binding.advertiseTitleTextView.text = advertiseTitleDialog
            }
            alertDialog.show()
        }
    }


    private fun explanation() {
        binding.explanationLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Açıklama"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.explanationTextView.text = explanationDialog
            }
            alertDialog.show()
        }
    }

    private fun price() {
        binding.priceLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.price_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val priceDialog =
                    mDialogView.findViewById<EditText>(R.id.priceAlertDialogEditText).text.toString()
                        .trim()

                binding.priceTextView.text = "$priceDialog TL"
            }
            alertDialog.show()
        }
    }

    private fun address() {
        binding.addressLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.address_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

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
            alertDialog.show()
        }
    }

    private fun brand() {
        binding.brandLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Marka"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val brandDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.brandTextView.text = brandDialog
            }
            alertDialog.show()
        }
    }

    private fun serial() {

        binding.serialLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Seri"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val serialDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.serialTextView.text = serialDialog
            }
            alertDialog.show()
        }
    }

    private fun model() {

        binding.modelLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Model"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val modelDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.modelTextView.text = modelDialog
            }
            alertDialog.show()
        }
    }

    private fun year() {
        binding.yearLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.number_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Yıl"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val yearDialog =
                    mDialogView.findViewById<EditText>(R.id.numberAlertDialogEditText).text.toString()
                        .trim()

                binding.yearTextView.text = yearDialog
            }
            alertDialog.show()

        }
    }

    private fun fuel() {
        binding.fuelLinearLayout.setOnClickListener {

            val fuels = resources.getStringArray(R.array.fuels)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, fuels)

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.fuel_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteFuelTextView)
                .setAdapter(arrayAdapter)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val fuelDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteFuelTextView).text.toString()

                binding.fuelTextView.text = fuelDialog
            }
            alertDialog.show()
        }
    }

    private fun gear() {
        binding.gearLinearLayout.setOnClickListener {

            val gears = resources.getStringArray(R.array.gears)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, gears)

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.gear_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGearTextView)
                .setAdapter(arrayAdapter)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val gearDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGearTextView).text.toString()

                binding.gearTextView.text = gearDialog
            }
            alertDialog.show()
        }
    }

    private fun vehicleStatus() {
        binding.vehicleStatusLinearLayout.setOnClickListener {

            val vehicleStatus = resources.getStringArray(R.array.vehicleStatus)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, vehicleStatus)

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.vehicle_status_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteVehicleStatusTextView)
                .setAdapter(arrayAdapter)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val vehicleStatusDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteVehicleStatusTextView).text.toString()

                binding.vehicleStatusTextView.text = vehicleStatusDialog
            }
            alertDialog.show()
        }
    }

    private fun km() {

        binding.kmLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.number_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "KM"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val vehicleStatusDialog =
                    mDialogView.findViewById<EditText>(R.id.numberAlertDialogEditText).text.toString()
                        .trim()

                binding.kmTextView.text = "$vehicleStatusDialog KM"
            }
            alertDialog.show()

        }
    }

    private fun caseType() {
        binding.caseTypeLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Kasa Tipi"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val caseTypeDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.caseTypeTextView.text = caseTypeDialog
            }
            alertDialog.show()

        }
    }

    private fun motorPower() {
        binding.motorPowerLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Motor Gücü"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val motorPowerDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.motorPowerTextView.text = motorPowerDialog
            }
            alertDialog.show()

        }
    }

    private fun motorCapacity() {
        binding.motorCapacityLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Motor Hacmi"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val motorCapacityDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.motorCapacityTextView.text = motorCapacityDialog
            }
            alertDialog.show()

        }
    }

    private fun traction() {
        binding.tractionLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Çekiş"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val tractionDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.tractionTextView.text = tractionDialog
            }
            alertDialog.show()
        }
    }

    private fun color() {
        binding.colorLinearLayout.setOnClickListener {

            val colors = resources.getStringArray(R.array.colors)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, colors)

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.color_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)


            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteColorTextView)
                .setAdapter(arrayAdapter)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val colorDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteColorTextView).text.toString()

                binding.colorTextView.text = colorDialog

            }
            alertDialog.show()
        }
    }

    private fun guarantee() {
        binding.guaranteeLinearLayout.setOnClickListener {

            val guarantees = resources.getStringArray(R.array.guarantees)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, guarantees)

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.guatantee_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGuaranteeTextView)
                .setAdapter(arrayAdapter)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val guaranteeDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteGuaranteeTextView).text.toString()

                binding.guaranteeTextView.text = guaranteeDialog
            }
            alertDialog.show()
        }
    }

    private fun swap() {
        binding.swapLinearLayout.setOnClickListener {

            val guarantees = resources.getStringArray(R.array.guarantees)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, guarantees)

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.swap_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteSwapTextView)
                .setAdapter(arrayAdapter)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val swapDialog =
                    mDialogView.findViewById<AutoCompleteTextView>(R.id.autoCompleteSwapTextView).text.toString()

                binding.swapTextView.text = swapDialog
            }
            alertDialog.show()
        }
    }

    private fun phoneNumber() {

        binding.phoneNumberLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.phone_number_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val phoneNumberDialog =
                    mDialogView.findViewById<EditText>(R.id.phoneNumberAlertDialogEditText).text.toString()
                        .trim()

                binding.phoneNumberTextView.text = phoneNumberDialog

            }
            alertDialog.show()

        }
    }
}

