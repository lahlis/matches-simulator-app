package me.dio.simulator.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    val name: String,
    val rate: Int,
    val image: String,
    var score: Int?
) : Parcelable