package com.example.app.ui.lists

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.data.ClockFrame

class QuizFragmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val capitalTextView: TextView = itemView.findViewById(R.id.capital_textview)
    val capitalImageView: ImageView = itemView.findViewById(R.id.clock_imageview)

    fun onBind(clock: ClockFrame) {
        capitalImageView.setImageDrawable(clock.drawable)
        capitalTextView.text = clock.capitalName
    }
}