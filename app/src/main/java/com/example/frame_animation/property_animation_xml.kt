package com.example.frame_animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_property_animation_xml.*

class property_animation_xml : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_animation_xml)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{


                val anim1 = ObjectAnimator.ofFloat(pImage, "scaleY", 0f, 1f)
                val anim2 = ObjectAnimator.ofFloat(pImage, "scaleX", 0f, 1f)
                val animationSet = AnimatorSet()
                animationSet.play(anim1).with(anim2)
                animationSet.duration = 1000
                animationSet.start()

                val rotation = ObjectAnimator.ofFloat(pImage,"alpha",0f,1f,0.5f)
                rotation.duration = 1000
                rotation.start()

                val translationAnimator = ObjectAnimator.ofFloat(pImage, "translationX", 0F,300f)
                val translationAnimator2 = ObjectAnimator.ofFloat(pImage, "translationY", 0F,300f)
                val set = AnimatorSet()
                set.play(translationAnimator).with(translationAnimator2)
                set.duration = 1000
                set.start()


                val rotationAnimator = ObjectAnimator.ofFloat(pImage, "rotation", 0F, 720f)
                rotationAnimator.duration = 1000
                rotationAnimator.interpolator = BounceInterpolator()
                rotationAnimator.start()

            }
        }
        return true
    }
}
