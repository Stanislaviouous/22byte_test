package com.example.app.ui.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.data.ClockFrame

class QuizFragmentAdapter(var clocksFramesList: List<ClockFrame>) : RecyclerView.Adapter<QuizFragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizFragmentViewHolder {
        return QuizFragmentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_clock, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: QuizFragmentViewHolder, position: Int) {
        holder.onBind(clocksFramesList[position])
    }

    override fun getItemCount() = clocksFramesList.size

}