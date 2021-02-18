package com.example.tinytimetracker

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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