package com.example.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var fragment = supportFragmentManager.findFragmentById(R.id.contanier)
//        if (fragment == null) {
//            val fragment = MemoryFragment.newInstance()
//            supportFragmentManager.beginTransaction().add(R.id.contanier, fragment).commit()
//        }
//
//        println("avast")

        val fragmentManager = supportFragmentManager
        fragmentManager!!.beginTransaction()
            .add(R.id.contanier, MainFragment())
            .commit();
    }
}