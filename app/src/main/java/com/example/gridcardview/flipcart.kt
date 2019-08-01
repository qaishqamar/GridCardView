package com.example.gridcardview

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class flipcart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flipcart)
        val myWebView: WebView = findViewById(R.id.fcart_id)//object creation

        myWebView.loadUrl("https://www.flipkart.com")//for loading url

        myWebView.settings.javaScriptEnabled = true//for enabling java script to perform amimations

        myWebView.webViewClient = WebViewClient()//for enabling in app clicks in web view

        //for downloading files in webview
        myWebView.setDownloadListener(DownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })


     }
    }

