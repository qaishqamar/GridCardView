package com.example.gridcardview

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.DownloadListener
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cv1.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, Main2Activity::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }

        cv2.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, facebook::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }


        cv4.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, snapdeal::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }
        cv5.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, olx::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }
        cv6.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, vocationalhub::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }
        cv7.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, twiter::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }
        cv8.setOnClickListener {
            var i = intent
            i = Intent(this@MainActivity, instagram::class.java)
            i.putExtra("abc", "123".toString())
            startActivity(i)

        }
    }
}