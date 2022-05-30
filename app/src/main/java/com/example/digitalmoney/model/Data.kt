package com.example.digitalmoney.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("id") var id : String,
    @SerializedName("symbol") var symbol : String,
    @SerializedName("name"  ) var name : String,
    @SerializedName("nameid") var nameid : String,
    @SerializedName("rank"  ) var rank : Int,
    @SerializedName("price_usd") var priceUsd : String,
    @SerializedName("percent_change_24h") var percentChange24h : String,
    @SerializedName("percent_change_1h") var percentChange1h  : String,
    @SerializedName("percent_change_7d") var percentChange7d  : String,
    @SerializedName("price_btc") var priceBtc         : String,
    @SerializedName("market_cap_usd") var marketCapUsd     : String,
    @SerializedName("volume24") var volume24 : Double,
    @SerializedName("volume24a") var volume24a : Double,
    @SerializedName("csupply") var csupply : String,
    @SerializedName("tsupply") var tsupply : String,
    @SerializedName("msupply") var msupply : String)