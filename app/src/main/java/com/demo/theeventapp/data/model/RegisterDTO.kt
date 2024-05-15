package com.demo.theeventapp.data.model

import com.google.gson.annotations.SerializedName


data class Root(
    @SerializedName("UserName")
    val userName: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Mobile")
    val mobile: String,
    @SerializedName("Password")
    val password: String,
    @SerializedName("Speciality")
    val speciality: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("InstagramLink")
    val instagramLink: String,
    @SerializedName("TikTokLink")
    val tikTokLink: String,
    @SerializedName("UserConsent")
    val userConsent: String,
)
