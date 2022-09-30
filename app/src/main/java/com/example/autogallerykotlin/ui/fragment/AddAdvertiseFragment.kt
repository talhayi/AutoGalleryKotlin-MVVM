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

    @SuppressLint("SetTextI18n")
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

    @SuppressLint("SetTextI18n")
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
}

