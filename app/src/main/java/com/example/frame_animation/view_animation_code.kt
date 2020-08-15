package com.example.frame_animation

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_animation_code.*


class view_animation_code : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_animation_code)

        pButton.setOnClickListener(){
            Intent().also {
                it.setClass(this,property_animation_xml::class.java)
                startActivity(it)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                val TrAnimation = TranslateAnimation(0F, 100F,0F,300F)
                val sAnimation = ScaleAnimation(0.1F,1.0F,0.1F,1.0F)
                val aAnimation = AlphaAnimation(0f,1f)
                val rAnimation = RotateAnimation(0f,360f)

                val animationSet = AnimationSet(true)
                animationSet.addAnimation(TrAnimation)
                animationSet.addAnimation(sAnimation)
                animationSet.addAnimation(aAnimation)
                animationSet.addAnimation(rAnimation)

                animationSet.duration = 2000
                animationSet.repeatCount = 2
                animationSet.interpolator = BounceInterpolator()
                codeImage.startAnimation(animationSet)

            }
        }
        return true
    }
}
