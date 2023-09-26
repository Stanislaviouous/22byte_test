package com.example.app.ui

import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import com.example.app.R
import com.example.app.core.Game
import com.example.app.data.ClockFrame
import java.text.ChoiceFormat

class QuizFragment : Fragment() {

    var prevClockFrame: ClockFrame? = null

    lateinit var buttonOk: Button
    lateinit var edittextWriteAnswer: EditText
    lateinit var clockVariant: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_quiz, container, false)


        // Инициализируем элементы
        edittextWriteAnswer = root.findViewById(R.id.edittext_write_answer)
        clockVariant = root.findViewById(R.id.clock_variant)

        clickOnButtonOK()

        // Обработка нажатия на кнопку
        buttonOk = root.findViewById<Button>(R.id.button_ok)
        buttonOk.setOnClickListener { clickOnButtonOK() }

        return root
    }

    fun clickOnButtonOK () {
        check()
        logic()
    }


    fun check() {
        if (prevClockFrame != null) {
            if (edittextWriteAnswer.getText().toString().trim() == prevClockFrame?.capitalName) Game.score += 1
            else Game.score -= 1
        }
    }

    fun logic() {
        if (Game.list.isNotEmpty()) {
            prevClockFrame = Game.list.removeLast()
            clockVariant.setImageDrawable(prevClockFrame?.drawable)
            edittextWriteAnswer.setText("")
            edittextWriteAnswer.hint = "WRITE ANSWER"
        }
        else {
            val fragmentManager = activity?.supportFragmentManager
            val fragment = EndFragment()
            fragmentManager!!.beginTransaction()
                .remove(this)
                .add(R.id.contanier, fragment)
                .commit()
        }
    }



}