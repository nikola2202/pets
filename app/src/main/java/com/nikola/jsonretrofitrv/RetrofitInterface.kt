package com.nikola.jsonretrofitrv

import android.telecom.Call
import retrofit2.http.GET

interface RetrofitInterface
{

    @GET ("raw/0b5bd646d468103f9b5279e68a7fd398c5b14eac/pets-list")
    fun fetchAllData(): retrofit2.Call<List<Pet>>

    companion object
    {
        const val BASE_URL = "https://gist.github.com/appec-bv/522bd8095aa5c0488e562e15c5b0ce84/"
    }

}