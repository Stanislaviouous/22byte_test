package com.example.app.ui
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.app.R
import com.example.app.core.Game

// Используется List, так как изменение списка не подразумевается
class MainFragment : Fragment() {
    lateinit var buttonPlay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        Game.new()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.example.app.R.layout.fragment_main, container, false)

        buttonPlay = root.findViewById(com.example.app.R.id.play_button)
        buttonPlay.setOnClickListener {
            val fragmentManager = activity?.supportFragmentManager
            fragmentManager!!.beginTransaction()
                .remove(this)
                .add(R.id.contanier, ChoiceFragment())
                .commit();
        }

        return root
    }

}