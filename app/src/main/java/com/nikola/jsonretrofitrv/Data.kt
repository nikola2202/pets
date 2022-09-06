package com.nikola.jsonretrofitrv


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("pets")
    val pets: List<Pet>
)