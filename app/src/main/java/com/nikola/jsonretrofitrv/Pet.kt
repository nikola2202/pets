package com.nikola.jsonretrofitrv


import com.google.gson.annotations.SerializedName

data class Pet(
    @SerializedName("birthYear")
    val birthYear: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("favFoods")
    val favFoods: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("species")
    val species: String
)