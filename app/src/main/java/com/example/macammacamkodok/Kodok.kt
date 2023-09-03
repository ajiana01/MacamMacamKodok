package com.example.macammacamkodok

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kodok(
    val nama: String,
    val anime: String,
    val penjelasan: String,
    val foto: Int
) : Parcelable

