package com.example.autogallerykotlin.ui.fragment

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.autogallerykotlin.R
import com.example.autogallerykotlin.databinding.FragmentUploadImagesBinding
import com.example.autogallerykotlin.viewmodel.AddAdvertiseImageViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream
import java.io.IOException

@Suppress("DEPRECATION")
@AndroidEntryPoint
class UploadImagesFragment : Fragment() {
    private var _binding: FragmentUploadImagesBinding? = null
    private val binding get() = _binding!!
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private var bitmap: Bitmap? = null
    private val viewModel: AddAdvertiseImageViewModel by viewModels()
    private var advertId = ""
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
            findNavController().navigate(UploadImagesFragmentDirections.actionUploadImagesFragmentToAddAdvertiseFragment())
        }
        selectImage(view)
        registerLauncher()
        addImage()
        addAdvertiseImage()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    findNavController().navigate(UploadImagesFragmentDirections.actionUploadImagesFragmentToAdvertsFragment())
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }
    private fun addAdvertiseImage(){
        viewModel.addAdvertiseImage.observe(viewLifecycleOwner){addAdvertiseImageResponse->
            if (addAdvertiseImageResponse.isSuccessful){
                if(addAdvertiseImageResponse.body()?.success ==true){
                    Toast.makeText(requireContext(), addAdvertiseImageResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(requireContext(), addAdvertiseImageResponse.body()?.result, Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(requireContext(), getString(R.string.not_issuccessful), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addImage(){
        binding.addImageButton.setOnClickListener {
            val sharedPreferences = this.activity?.getSharedPreferences(getString(R.string.shared_pref_login), AppCompatActivity.MODE_PRIVATE)
            val userId = sharedPreferences?.getString(getString(R.string.shared_pref_user_id), null)!!
            arguments?.let {
                advertId = UploadImagesFragmentArgs.fromBundle(it).advertId
            }
            val image = imageToString()
                viewModel.addAdvertiseImage(userId,advertId,image)
        }
    }
    private fun selectImage(view: View) {
        binding.pickImageButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    val snackbar = Snackbar.make(view, getString(R.string.permission_gallery), Snackbar.LENGTH_INDEFINITE)
                    snackbar.setActionTextColor(Color.WHITE)
                    snackbar.setBackgroundTint(resources.getColor( R.color.primary_color))
                    snackbar.setAction(getString(R.string.give_permission)) {
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
    private fun imageToString(): String {
        val smallBitmap = makeSmallerBitmap(bitmap!!,300)
        val outputStream = ByteArrayOutputStream()
        smallBitmap. compress(Bitmap.CompressFormat.PNG,50,outputStream)
        val byteArray = outputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
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
                                bitmap = ImageDecoder.decodeBitmap(source)
                                binding.uploadImageView.setImageBitmap(bitmap)
                                binding.uploadImageView.visibility = View.VISIBLE

                            }
                            else {
                                bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageData)
                                binding.uploadImageView.setImageBitmap(bitmap)
                                binding.uploadImageView.visibility = View.VISIBLE
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
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            } else {
                //permission denied
                Toast.makeText(requireContext(), getString(R.string.permission_gallery), Toast.LENGTH_LONG).show()
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
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}