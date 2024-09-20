package com.example.mygit

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mygit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.git.loadUrl("https://github.com/")
        binding.git.settings.javaScriptEnabled = true

        binding.git.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.git.visibility = View.GONE
                binding.bar.visibility = View.VISIBLE


            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                binding.git.visibility = View.VISIBLE
                binding.bar.visibility = View.GONE
            }

        }

    }

    override fun onBackPressed() {
        if (binding.git.canGoBack()) {
            binding.git.goBack()
        } else {
            super.onBackPressed()
        }

    }
}