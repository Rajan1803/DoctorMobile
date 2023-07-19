package com.example.doctormobile.fragments

import android.net.Uri
import android.os.Bundle
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
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        var contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
            if (it != null) {
                binding.imgvProfilePic.setImageURI(it)
                upload()
            }
        }
        binding.rvProfileItems.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProfileAdapter()
        }
        binding.imgvProfilePic.setOnClickListener {
            contract.launch("image/*")
        }
    }

    private fun upload() {
        val filesDir = activity?.applicationContext?.filesDir
        val file = File(filesDir, "image.png")
        val requestFile: RequestBody =
            RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
        val call = ApiClient.uploadService.postImage("2000b43f5584c437ff44df736ba33d8c", body)
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
    }
}