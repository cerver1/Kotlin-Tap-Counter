package com.fair.counter1234

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Increase: Fragment(R.layout.increase) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val increased = view.findViewById<TextView>(R.id.txtIncreasing)
        val resetFab = view.findViewById<FloatingActionButton>(R.id.fabResetIncreasing)
        var initialIncrease = 0

        increased.setOnClickListener {
            initialIncrease++
            increased.text = initialIncrease.toString()
            resetFab.visibility = View.VISIBLE
        }

        resetFab.setOnClickListener {
            initialIncrease = 0
            increased.text = initialIncrease.toString()
            resetFab.visibility = View.INVISIBLE
        }


    }

}