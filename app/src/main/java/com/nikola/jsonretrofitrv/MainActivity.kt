package com.nikola.jsonretrofitrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.nikola.jsonretrofitrv.Data
import com.nikola.jsonretrofitrv.Pet


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getData()

    }

    private fun getData() {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(RetrofitInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        val retrofitData = retrofitBuilder.fetchAllData()

        retrofitData.enqueue(object : Callback<List<Pet>?> {
            override fun onResponse(call: Call<List<Pet>?>, response: Response<List<Pet>?>)
            {
                val responseBody = response.body()!!

                myAdapter = DataAdapter(baseContext,responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter


            }

            override fun onFailure(call: Call<List<Pet>?>, t: Throwable)
            {
                Toast.makeText(applicationContext,"Failure",Toast.LENGTH_SHORT ).show()
            }
        })
    }
}
