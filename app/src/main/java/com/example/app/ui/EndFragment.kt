package com.example.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.app.R
import com.example.app.core.Game
import com.google.android.material.color.utilities.Score

class EndFragment : Fragment() {
    lateinit var scoreText: TextView
    lateinit var buttonRestart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_end, container, false)

        // Инициализируем
        scoreText = root.findViewById(R.id.score)
        scoreText.text = Game.score.toString()

        buttonRestart = root.findViewById(R.id.button_restart)
        buttonRestart.setOnClickListener {
            Game.new()
            val fragmentManager = activity?.supportFragmentManager
            val fragment = MainFragment()
            fragmentManager!!.beginTransaction()
                .remove(this)
                .add(R.id.contanier, fragment)
                .commit()
        }

        return root
    }

}