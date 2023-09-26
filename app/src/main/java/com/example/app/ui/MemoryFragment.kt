package com.example.app.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.core.Game
import com.example.app.core.Game.Companion.CASUAL
import com.example.app.core.Game.Companion.PLAY_FOR_TIME
import com.example.app.core.Timer
import com.example.app.data.ClockFrame
import com.example.app.data.ClockFrameRepository
import com.example.app.ui.lists.QuizFragmentAdapter
import kotlin.concurrent.timer


class MemoryFragment : Fragment() {

    lateinit var countDownTimer: Timer
    lateinit var buttonComplete: Button
    lateinit var timer: TextView
    lateinit var list: List<ClockFrame>
    lateinit var recyclerView: RecyclerView

    var flag: Int = CASUAL

    override fun onCreate(savedInstanceState: Bundle?) {
        flag = Game.flag
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_memory, container, false)

        // При нажатии кнопки переходим на следующий экран
        buttonComplete = root.findViewById<Button>(R.id.button_complete)
        buttonComplete.setOnClickListener { replaceFragment(list) }

        // Заполняем RecyclerView
        list = ClockFrameRepository().getClocks(root.context)

        recyclerView = root.findViewById<RecyclerView>(R.id.recycler_clocks)
        val adapter = QuizFragmentAdapter(list)
        recyclerView.layoutManager = GridLayoutManager(root.context, 3)
        recyclerView.adapter = adapter

        // Связываем timer
        timer = root.findViewById(R.id.timer)
        timer.visibility = View.VISIBLE

        return root
    }

    override fun onStart() {
        super.onStart()
        // В зависимости от режима, начинается разная игра
        if (flag == PLAY_FOR_TIME) {
            countDownTimer = Timer(timer, this)
            countDownTimer.start()
        }
        else {
            timer.visibility = View.INVISIBLE
        }
    }

    fun replaceFragment(list: List<ClockFrame>) {
        Game.list.addAll(list.reversed())
        if(Game.flag == Game.PLAY_FOR_TIME) countDownTimer.cancel()

        val fragmentManager = activity?.supportFragmentManager
        val fragment = QuizFragment()
        fragmentManager?.beginTransaction()
            ?.remove(this)
            ?.add(R.id.contanier, fragment)
            ?.commit()
    }
}