package com.example.app.core

import android.os.CountDownTimer
import android.widget.TextView
import com.example.app.data.ClockFrame
import com.example.app.ui.EndFragment
import com.example.app.ui.MemoryFragment
import kotlin.concurrent.thread

class Game {
    companion object {
        val CASUAL = 0
        val PLAY_FOR_TIME = 1

        var flag = CASUAL
        var list: ArrayList<ClockFrame> = ArrayList()
        var score = 0

        fun new() {
            flag = CASUAL
            list = ArrayList()
            score = 0
        }
        fun format(millisUntilFinished: Long) : String{
            val sec = (millisUntilFinished / 1000) % 60
            val min = ((millisUntilFinished / 1000) / 60) % 60
            val hou = ((millisUntilFinished / 1000) / 60) / 60
            var form = "";
            if (hou > 0) form = "%02d:%02d:%02d".format(hou, min, sec)
            else form = "%02d:%02d".format(min, sec)
            return form
        }
    }
}

class Timer(var timer: TextView, var fragment: MemoryFragment): CountDownTimer(30000, 1000) {
    override fun onTick(millisUntilFinished: Long) {
        timer.text = Game.format(millisUntilFinished)
    }
    override fun onFinish() {
        fragment.replaceFragment(fragment.list)
    }
}