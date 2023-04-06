package com.test.fingering

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.fingering.ui.theme.FingeringTheme
import retrofit2.Call
import retrofit2.Callback

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            FingeringTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var data: String = ""
    RetrofitClient.api.get().enqueue(object : Callback<Response>{
        override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
            if(response.code() == 200){
                data = response.body().toString()
                Log.d("상태",response.body().toString())
            } else {
                Log.d("상태",response.code().toString())
            }
        }

        override fun onFailure(call: Call<Response>, t: Throwable) {
            //error
            Log.d("상태",t.message.toString())
        }

    })

    Text(text = "Hello $data")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FingeringTheme {
        Greeting("Android")
    }
}
