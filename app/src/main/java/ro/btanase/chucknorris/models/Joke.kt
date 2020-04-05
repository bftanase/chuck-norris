package ro.btanase.chucknorris.models

import com.google.gson.annotations.SerializedName

data class Joke (
    @SerializedName("value")
    val text : String,
    @SerializedName("id")
    val id: String,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("icon_url")
    val iconUrl: String



)