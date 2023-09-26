package com.example.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.app.R
import com.example.app.core.Game
import com.example.app.core.Game.Companion.CASUAL
import com.example.app.core.Game.Companion.PLAY_FOR_TIME

class ChoiceFragment : Fragment() {
    lateinit var buttonCasual: Button
    lateinit var buttonPlayForTime: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_choice, container, false)

        buttonCasual = root.findViewById(R.id.button_casual)
        buttonPlayForTime = root.findViewById(R.id.button_play_to_time)

        buttonCasual.setOnClickListener { replaceFragment(CASUAL) }
        buttonPlayForTime.setOnClickListener { replaceFragment(PLAY_FOR_TIME) }

        return root
    }

    fun replaceFragment(flag: Int) {
        val fragmentManager = activity?.supportFragmentManager
        val fragment = MemoryFragment()
        Game.flag = flag
        fragmentManager!!.beginTransaction()
            .remove(this)
            .add(R.id.contanier, fragment)
            .commit();
    }

}