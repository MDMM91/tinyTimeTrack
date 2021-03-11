package com.example.tinytimetracker

import android.animation.Animator
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.TransitionDrawable
import android.os.Build
import android.os.Bundle
import android.transition.Transition
import android.view.Window
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.StackView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.util.*


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
        var bigButton = findViewById(R.id.button3) as Button
        // set on-click listener
        bigButton.setOnClickListener {
            changeColor()
        }

        val recents = findViewById(R.id.lastbookingStack) as LinearLayout
        recents.setOnClickListener{
            openDetailPage()
        }

        // get reference to button
        val btn_click_me = findViewById(R.id.imageButton) as ImageButton
        // set on-click listener
        btn_click_me.setOnClickListener {
            openDetailPage()
        }
    }


    fun changeColor() {
        var bigButton = findViewById(R.id.button3) as Button
        val buttonColor = bigButton.getBackground()
       // Thread.sleep(1_000)
        //bigButton.setBackgroundColor(C);

        val asda: ValueAnimator;
        val R = 243
        val G = 57
        val B = 57



        val valueAnimator = ValueAnimator.ofInt(0, 255)

        val wrapper: DBContextEntityWrapper = DBContextEntityWrapper(this);
        wrapper.addBookingEntry("");
        wrapper.getBookings();

//2
        valueAnimator.addUpdateListener {
            // 3
            val value = it.animatedValue as Int
            // 4
            bigButton.setBackgroundColor(Color.argb(value, R,G,B));
        }
        var asd222 =  Booking();
        asd222.TimeStamp = java.util.Calendar.getInstance().time as java.util.Date?
        bigButton.text = asd222.TimeStamp.toString();
//5
        valueAnimator.interpolator = AccelerateInterpolator()
        valueAnimator.duration = 700

//6
        valueAnimator.start()


        var asd :Transition;


    }


    fun openDetailPage() {

        // start the new activity

        val intent = Intent(this, DetailWindow::class.java)

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}