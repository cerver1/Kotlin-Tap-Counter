package com.fair.counter1234

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.fair.counter1234.databinding.IncreaseBinding

class Increase: Fragment(R.layout.increase) {

    private var _increaseBinding: IncreaseBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = IncreaseBinding.bind(view)
        _increaseBinding = binding

        with(binding){

            var initialIncrease = 0

            txtIncreasing.setOnClickListener {

                initialIncrease++
                txtIncreasing.text = initialIncrease.toString()
                fabResetIncreasing.visibility = View.VISIBLE
            }

            fabResetIncreasing.setOnClickListener {

                initialIncrease = 0
                txtIncreasing.text = initialIncrease.toString()
                fabResetIncreasing.visibility = View.INVISIBLE
            }

        }


    }

    override fun onDestroyView() {

        _increaseBinding = null
        super.onDestroyView()
    }


}