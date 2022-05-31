package com.example.digitalmoney.ui.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.digitalmoney.R
import com.example.digitalmoney.databinding.ActivityMainBinding
import com.example.digitalmoney.databinding.ActivitySplashBinding
import com.example.digitalmoney.ui.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        if (hasNetWork()) {
            Handler(mainLooper).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 5000)
        } else {

        }
    }

    fun hasNetWork(): Boolean {
        val connectManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            connectManager.activeNetwork?.let { network ->
                connectManager.getNetworkCapabilities(network)?.let { capabilities ->
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        else -> false
                    }
                } ?: false
            } ?: false
        } else {
            val networkInfo: NetworkInfo? = connectManager.activeNetworkInfo
            networkInfo?.run { isConnected == true } ?: false

        }
    }
}