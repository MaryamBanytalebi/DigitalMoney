package com.example.digitalmoney.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.digitalmoney.databinding.FragmentDetailBinding
import com.example.digitalmoney.data.model.Data
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var data: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().getParcelable<Data>("data")?.let {
            Log.d("TAG", "onCreate: $it")
            data = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data?.let {
            with(binding) {
                textView1.text = "id: ${it.id}"
                textView2.text = "symbol: " + it.symbol
                textView3.text = "name: " + it.name
                textView4.text = "name id: " + it.nameid
                textView5.text = "rank: " + it.rank.toString()
                textView6.text = "priceUsd: " + it.priceUsd
                textView7.text = "percentChange24h: " + it.percentChange24h
                textView8.text = "percentChange1h: " + it.percentChange1h
                textView9.text = "percentChange7d: " + it.percentChange7d
                textView10.text = "priceBtc: " + it.priceBtc
                textView11.text = "marketCapUsd: " + it.marketCapUsd
                textView12.text = "volume24: " + it.volume24.toString()
                textView13.text = "volume24a: " + it.volume24a.toString()
                textView14.text = "csupply: " + it.csupply
                textView15.text = "tsupply: " + it.tsupply
                textView16.text = "msupply: " + it.msupply
            }
        }
    }


}