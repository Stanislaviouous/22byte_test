package com.example.app.data

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import com.example.app.R

// Иммитация получения данных
class ClockFrameRepository {
    var clocks = mutableListOf<Pair<String, Int>>(
        Pair<String, Int>("Astana", R.drawable.astana),
        Pair<String, Int>("London", R.drawable.london),
        Pair<String, Int>("Canberra", R.drawable.canberra),
        Pair<String, Int>("Honiara", R.drawable.honiara),
        Pair<String, Int>("Bangkok", R.drawable.bangkok),
        Pair<String, Int>("Manila", R.drawable.manila),
        Pair<String, Int>("Tokyo", R.drawable.tokyo),
        Pair<String, Int>("Newdelhi", R.drawable.newdelhi)
    )

    // Может вернуть null
    fun getClocks(context: Context): List<ClockFrame> {
        clocks.forEach{it-> println("${it.first} ${it.second}") }
        return buildList {
            (clocks.indices).shuffled().take((6..8).random()).forEach { it ->
                add(
                    ClockFrame(clocks[it].first,
                        AppCompatResources.getDrawable(context, clocks[it].second)!!
                    ))
            }

        }
    }

}