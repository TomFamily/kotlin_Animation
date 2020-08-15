package com.example.frame_animation

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    var animation = AnimationDrawable()
    var isStart = true
    private var pictureArray = arrayOf(R.drawable.campfire01,R.drawable.campfire02,
        R.drawable.campfire03,R.drawable.campfire04,R.drawable.campfire05,
        R.drawable.campfire06,R.drawable.campfire07,R.drawable.campfire08,R.drawable.campfire09,
        R.drawable.campfire10,R.drawable.campfire11,R.drawable.campfire12,R.drawable.campfire13,
        R.drawable.campfire14,R.drawable.campfire15,R.drawable.campfire16,R.drawable.campfire17)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent.getStringExtra("yk").also {
            Log.v("yk",it!!)
        }

        tween_animation.setOnClickListener(){
            Intent().also {
                it.setClass(this,view_animation::class.java)
                startActivity(it)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                for (item in pictureArray){
                    animation.addFrame(resources.getDrawable(item,null), 100)
                }
                ykImage2.setImageDrawable(animation)
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
