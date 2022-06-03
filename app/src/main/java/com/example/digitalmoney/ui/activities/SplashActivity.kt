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
import android.view.View
import android.view.WindowManager
import android.widget.Toast
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
            doWork()
            binding.btnRetry.visibility = View.INVISIBLE
        } else {
            Toast.makeText(this, "no connection", Toast.LENGTH_SHORT).show()
        }
        binding.btnRetry.setOnClickListener {
            if (hasNetWork())
                doWork()
            else
                Toast.makeText(this, "no connection", Toast.LENGTH_SHORT).show()
        }

    }

    private fun doWork() {
        Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }

    fun hasNetWork(): Boolean {
        val connectManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            connectManager.activeNetwork?.let { network ->
                connectManager.getNetworkCapabilities(network)?.let { capabilities ->
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
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