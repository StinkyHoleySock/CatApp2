package com.example.apiexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->

            if (isConnected) {
                containerView.visibility = View.VISIBLE
                layout_check_connection.visibility = View.GONE
            } else {
                containerView.visibility = View.GONE
                layout_check_connection.visibility = View.VISIBLE
            }

        })
    }
}

