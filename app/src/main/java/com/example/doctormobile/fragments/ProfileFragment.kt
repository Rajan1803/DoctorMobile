package com.example.doctormobile.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctormobile.adapters.ProfileAdapter
import com.example.doctormobile.databinding.FragmentProfileBinding
import com.example.doctormobile.model.UploadedImage
import com.example.doctormobile.network.ApiClient
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File


class ProfileFragment : Fragment() {


    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater)

        initViews()

        return binding.root
    }

    /**
     * setting Views
     */
    private fun initViews() {
        val contactLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
            if (it != null) {
                binding.imgvProfilePic.setImageURI(it)
                upload(it)
            }
        }
        binding.rvProfileItems.layoutManager = LinearLayoutManager(activity)
        binding.rvProfileItems.adapter = ProfileAdapter()

        binding.imgvProfilePic.setOnClickListener {
            contactLauncher.launch("image/*")
        }
    }

    private fun upload(imageUri: Uri) {
        val filesDir = activity?.applicationContext?.filesDir
        val file = File(filesDir, "image.png")

        val requestFile: RequestBody =
            RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
        val call = ApiClient.uploadService.postImage(
            key = "2000b43f5584c437ff44df736ba33d8c",
            image = body
        )
        call.enqueue(object : retrofit2.Callback<UploadedImage> {
            override fun onResponse(
                call: Call<UploadedImage>,
                response: Response<UploadedImage>
            ) {
                print(response)
            }

            override fun onFailure(call: Call<UploadedImage>, t: Throwable) {
                print(t)
            }
        })

        Log.d("upload", call.toString())

    }


}