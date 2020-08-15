package com.example.frame_animation

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ykbutton.setOnClickListener(){
            Intent().also {
                it.setClass(this,Main2Activity::class.java)
                it.putExtra("yk","你好啊")
                startActivity(it)
            }
        }
    }

    var isStart = true
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                var animation = ykimageView.drawable as AnimationDrawable
                if (isStart){
                    animation.start()
                }else{
                    animation.stop()
                }
                isStart = !isStart
            }
        }
        return true
    }
}
