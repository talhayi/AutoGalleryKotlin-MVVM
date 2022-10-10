package com.example.autogallerykotlin.ui.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.autogallerykotlin.databinding.FragmentUploadImagesBinding
import com.google.android.material.snackbar.Snackbar
import java.io.IOException
import android.Manifest
import android.graphics.Color
import android.view.Gravity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.autogallerykotlin.R


class UploadImagesFragment : Fragment() {
    private var _binding: FragmentUploadImagesBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private var selectedBitmap: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUploadImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.uploadImageBackButton.setOnClickListener {
            findNavController().navigate(UploadImagesFragmentDirections.actionUploadImagesFragmentToAdvertsFragment())
        }
        selectImage(view)
        registerLauncher()
      //  makeSmallerBitmap()

    }

    private fun selectImage(view: View) {
        binding.pickImageButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {

                    val snackbar = Snackbar.make(view, "Galeri için izin gerekiyor", Snackbar.LENGTH_INDEFINITE)

                    snackbar.setActionTextColor(Color.WHITE)
                    snackbar.setBackgroundTint(resources.getColor( R.color.primary_color))
                    snackbar.setAction("İzin Ver") {
                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                    }.show()
                    val params = snackbar.view.layoutParams as CoordinatorLayout.LayoutParams
                    params.anchorId = R.id.navigationBottomBar //id of the bottom navigation view

                    params.gravity = Gravity.TOP
                    params.anchorGravity = Gravity.TOP
                    snackbar.view.layoutParams = params

                }
                else {
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                }
            }
            else {
                val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            }
        }
    }


    private fun registerLauncher() {
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {

                    val intentFromResult = result.data

                    if (intentFromResult != null) {

                        val imageData = intentFromResult.data

                        try {
                            if (Build.VERSION.SDK_INT >= 28) {

                                val source = ImageDecoder.createSource(requireActivity().contentResolver, imageData!!)

                                selectedBitmap = ImageDecoder.decodeBitmap(source)

                                binding.imageView.setImageBitmap(selectedBitmap)
                            }
                            else {
                                selectedBitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageData)
                                binding.imageView.setImageBitmap(selectedBitmap)
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                    //permission granted
                val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)

                }
            else {
                    //permission denied
                    Toast.makeText(requireContext(), "İzin gerekiyor", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun makeSmallerBitmap(image: Bitmap, maximumSize : Int) : Bitmap {
        var width = image.width
        var height = image.height

        val bitmapRatio : Double = width.toDouble() / height.toDouble()
        if (bitmapRatio > 1) {
            width = maximumSize
            val scaledHeight = width / bitmapRatio
            height = scaledHeight.toInt()
        } else {
            height = maximumSize
            val scaledWidth = height * bitmapRatio
            width = scaledWidth.toInt()
        }
        return Bitmap.createScaledBitmap(image,width,height,true)
    }
}