package com.example.autogallerykotlin.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.FragmentAddAdvertiseBinding
@SuppressLint("SetTextI18n")
class AddAdvertiseFragment : Fragment() {

    private var _binding: FragmentAddAdvertiseBinding? = null
    private val binding get() = _binding!!

    private lateinit var alertDialog: AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddAdvertiseBinding.inflate(inflater, container, false)
        return binding.root


    }

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
        km()/*
        caseType()
        motorPower()
        motorCapacity()
        traction()
        color()
        guarantee()
        swap()
        phoneNumber()*/







/*
        binding.addAdvertiseButton.setOnClickListener {

            activity?.let{
                val intent = Intent (it, MainActivity::class.java)
                it.startActivity(intent)
            }

            val action = AddAdvertiseFragmentDirections.actionAddAdvertiseFragmentToAdvertsFragment()
            Navigation.findNavController(view).navigate(action)
        }*/

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

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.priceAlertDialogEditText).text.toString()
                        .trim()

                binding.priceTextView.text = "$explanationDialog TL"
            }
            alertDialog.show()
        }
    }

    private fun address(){
        //TODO ADRES EKELENECEK
    }

    private fun brand(){
        binding.brandLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Marka"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.brandTextView.text = explanationDialog
            }
            alertDialog.show()
        }
    }

    private fun serial(){

        binding.serialLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Seri"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.serialTextView.text = explanationDialog
            }
            alertDialog.show()
        }
    }

    private fun model(){

        binding.modelLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.one_edit_text_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            mDialogView.findViewById<TextView>(R.id.textView).text = "Model"

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.alertDialogOneEditText).text.toString()
                        .trim()

                binding.modelTextView.text = explanationDialog
            }
            alertDialog.show()
        }
    }

    private fun year(){
        binding.yearLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.number_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.numberAlertDialogEditText).text.toString()
                        .trim()

                binding.yearTextView.text = explanationDialog
            }
            alertDialog.show()

        }
    }
    private fun fuel(){
    //todo radioButton or spinner
    }

    private fun gear(){
        //todo radioButton or spinner
    }

    private fun vehicleStatus(){
        //todo radioButton or spinner
    }
    private fun km(){
        binding.kmLinearLayout.setOnClickListener {

            val mDialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.number_alert_dialog, null)

            alertDialog = AlertDialog.Builder(requireContext()).setView(mDialogView)

            alertDialog.setNegativeButton("İPTAL") { _, _ -> }

            alertDialog.setPositiveButton("TAMAM") { _, _ ->

                val explanationDialog =
                    mDialogView.findViewById<EditText>(R.id.numberAlertDialogEditText).text.toString()
                        .trim()

                binding.kmTextView.text = "$explanationDialog KM"
            }
            alertDialog.show()

        }
    }

}

