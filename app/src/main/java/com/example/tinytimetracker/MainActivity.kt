package com.example.tinytimetracker

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        // get reference to button
        val btn_click_me = findViewById(R.id.imageButton) as ImageButton
        // set on-click listener
        btn_click_me.setOnClickListener {
            openDetailPage()
        }
    }

    fun openDetailPage() {

        // start the new activity

        val intent = Intent(this, DetailWindow::class.java)

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}