package com.example.digitalmoney.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item (val id : Int, val name : String, val image : Int) : Parcelable