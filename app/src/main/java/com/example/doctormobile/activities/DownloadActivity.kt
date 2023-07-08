package com.example.doctormobile.activities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.doctormobile.databinding.ActivityDownloadBinding
import com.example.doctormobile.model.User
import com.example.doctormobile.model.UserResponse
import com.example.doctormobile.network.ApiClient
import com.example.doctormobile.viewmodel.DownloadViewModel
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DownloadActivity : AppCompatActivity() {
    lateinit var viewModel: DownloadViewModel
    lateinit var binding: ActivityDownloadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        jsonParsing()
    }

    private fun jsonParsing() {
        val jsonString = """
            {
	"predictions": [{
			"description": "Paris, France",
			"matched_substrings": [{
				"length": 5,
				"offset": 0
			}],
			"place_id": "ChIJD7fiBh9u5kcRYJSMaMOCCwQ",
			"reference": "ChIJD7fiBh9u5kcRYJSMaMOCCwQ",
			"structured_formatting": {
				"main_text": "Paris",
				"main_text_matched_substrings": [{
					"length": 5,
					"offset": 0
				}],
				"secondary_text": "France"

			},
			"terms": [{
					"offset": 0,
					"value": "Paris"
				},
				{
					"offset": 7,
					"value": "France"
				}

			],
			"types": [
				"locality",
				"political",
				"geocode"
			]

		},
		{
			"description": "Paris, TX, USA",
			"matched_substrings": [{
				"length": 5,
				"offset": 0
			}],
			"place_id": "ChIJmysnFgZYSoYRSfPTL2YJuck",
			"reference": "ChIJmysnFgZYSoYRSfPTL2YJuck",
			"structured_formatting": {
				"main_text": "Paris",
				"main_text_matched_substrings": [{
					"length": 5,
					"offset": 0
				}],
				"secondary_text": "TX, USA"

			},
			"terms": [{
					"offset": 0,
					"value": "Paris"
				},
				{
					"offset": 7,
					"value": "TX"
				},
				{
					"offset": 11,
					"value": "USA"
				}

			],
			"types": [
				"locality",
				"political",
				"geocode"
			]

		},
		{
			"description": "Paris, TN, USA",
			"matched_substrings": [{
				"length": 5,
				"offset": 0
			}],
			"place_id": "ChIJ4zHP-Sije4gRBDEsVxunOWg",
			"reference": "ChIJ4zHP-Sije4gRBDEsVxunOWg",
			"structured_formatting": {
				"main_text": "Paris",
				"main_text_matched_substrings": [{
					"length": 5,
					"offset": 0
				}],
				"secondary_text": "TN, USA"

			},
			"terms": [{
					"offset": 0,
					"value": "Paris"
				},
				{
					"offset": 7,
					"value": "TN"
				},
				{
					"offset": 11,
					"value": "USA"
				}

			],
			"types": [
				"locality",
				"political",
				"geocode"
			]

		},
		{
			"description": "Paris, Brant, ON, Canada",
			"matched_substrings": [{
				"length": 5,
				"offset": 0
			}],
			"place_id": "ChIJsamfQbVtLIgR-X18G75Hyi0",
			"reference": "ChIJsamfQbVtLIgR-X18G75Hyi0",
			"structured_formatting": {
				"main_text": "Paris",
				"main_text_matched_substrings": [{
					"length": 5,
					"offset": 0
				}],
				"secondary_text": "Brant, ON, Canada"

			},
			"terms": [{
					"offset": 0,
					"value": "Paris"
				},
				{
					"offset": 7,
					"value": "Brant"
				},
				{
					"offset": 14,
					"value": "ON"
				},
				{
					"offset": 18,
					"value": "Canada"
				}

			],
			"types": [
				"neighborhood",
				"political",
				"geocode"
			]

		},
		{
			"description": "Paris, KY, USA",
			"matched_substrings": [{
				"length": 5,
				"offset": 0
			}],
			"place_id": "ChIJsU7_xMfKQ4gReI89RJn0-RQ",
			"reference": "ChIJsU7_xMfKQ4gReI89RJn0-RQ",
			"structured_formatting": {
				"main_text": "Paris",
				"main_text_matched_substrings": [{
					"length": 5,
					"offset": 0
				}],
				"secondary_text": "KY, USA"

			},
			"terms": [{
					"offset": 0,
					"value": "Paris"
				},
				{
					"offset": 7,
					"value": "KY"
				},
				{
					"offset": 11,
					"value": "USA"
				}

			],
			"types": [
				"locality",
				"political",
				"geocode"
			]

		}

	],
	"status": "OK"

}
        """

        fun parseJson(jsonString: String): List<String> {
            val mainTextList = mutableListOf<String>()

            val jsonObject = JSONObject(jsonString)
            val predictionsArray = jsonObject.getJSONArray("predictions")
            for (i in 0 until predictionsArray.length()) {
                val prediction = predictionsArray.getJSONObject(i)
                val structuredFormatting = prediction.getJSONObject("structured_formatting")
                val mainText = structuredFormatting.getString("main_text")
                mainTextList.add(mainText)
            }

            return mainTextList
        }
        val list = parseJson(jsonString)
        print(list)
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this)[DownloadViewModel::class.java]
        binding.btnDownload.setOnClickListener {
            putData()
            download()
            patchData()
        }
        viewModel.downloadedData.observe(this) { responseBody ->

            val bitmap = BitmapFactory.decodeStream(responseBody?.byteStream())
            binding.imageView.setImageBitmap(bitmap)
        }
    }


    private fun download() {


        viewModel.download()
    }

    private fun putData() {
        val call = ApiClient.putServiece.putData(User("morpheus","zion resident"))
        call.enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                Log.d("put", response.body().toString())
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("put", "onFailure: ")
            }

        })

    }

    private fun patchData(){
        val call = ApiClient.putServiece.patchData(User("morpheus","zion resident"))
        call.enqueue(object: Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                Log.d("patch", response.body().toString())
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("patch", "onFailure: ")
            }

        })
    }


}