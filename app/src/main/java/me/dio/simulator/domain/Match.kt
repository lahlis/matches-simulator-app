package me.dio.simulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match (
    val description: String,
    val place: Place,
    @SerializedName("home_team")
    val homeTeam: Team,
    @SerializedName("away_team")
    val awayTeam: Team
) : Parcelable