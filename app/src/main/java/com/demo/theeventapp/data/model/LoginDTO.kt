package com.demo.theeventapp.data.model

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("Message")
    val message: String,
    val eventid: Any?,
    @SerializedName("Status")
    val status: Boolean,
    val id: Long,
    @SerializedName("Useruniqueid")
    val useruniqueid: String,
    @SerializedName("QrCode")
    val qrCode: String,
    @SerializedName("DoctorName")
    val doctorName: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("EventIds")
    val eventIds: List<EventId>,
)

data class EventId(
    @SerializedName("Id")
    val id: Long,
    @SerializedName("UserId")
    val userId: Long,
    @SerializedName("EventId")
    val eventId: Long,
    @SerializedName("DateTime")
    val dateTime: Any?,
    @SerializedName("IsActive")
    val isActive: Boolean,
)
