package com.example.frame_animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import kotlinx.android.synthetic.main.activity_view_animation.*

class view_animation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_animation)

        viewButton.setOnClickListener(){
            Intent().also {
                it.setClass(this,view_animation_code::class.java)
                startActivity(it)
            }
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                var anim = AnimationUtils.loadAnimation(this,R.anim.tween_animation)
                anim.interpolator = BounceInterpolator()
                ykImage3.startAnimation(anim)
            }
        }
        return true
    }
}
