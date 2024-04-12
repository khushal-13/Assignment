package com.example.assignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Products : AppCompatActivity() {
    lateinit var myAdapter : MyAdapter
    lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        recycler = findViewById(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //if API call is a success, then use the data of API and show in your app
                val responseBody = response.body()
                val productList = responseBody?.products!!

                myAdapter = MyAdapter(this@Products, productList)
                recycler.adapter = myAdapter
                recycler.layoutManager = LinearLayoutManager(this@Products)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                //if API call fails
                Log.d("Main Activity", "onFailure : "+t.message)
            }
        })




    }
}