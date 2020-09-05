package com.fair.counter1234

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fair.counter1234.databinding.IncreaseBinding

class Increase: Fragment(R.layout.increase) {

    private var _increaseBinding: IncreaseBinding? = null
    private val viewBinding get() = _increaseBinding!!

    private lateinit var preferences: SharedPreferences
    private val model : GlobalViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _increaseBinding = IncreaseBinding.bind(view)

        preferences = SharedPreferences(context)
        model._incremental.value = preferences.getIncrementalCount()

        viewBinding.apply {

            model.incremental.observe(viewLifecycleOwner, {
                txtIncreasing.text = it.toString()
            })

            txtIncreasing.setOnClickListener {
                model.incrementOnClick()

//                initialIncrease++
//                txtIncreasing.text = initialIncrease.toString()
//                fabResetIncreasing.visibility = View.VISIBLE
            }

            fabResetIncreasing.setOnClickListener {

//                initialIncrease = 0
//                txtIncreasing.text = initialIncrease.toString()
//                fabResetIncreasing.visibility = View.INVISIBLE
            }

        }


    }

    override fun onStop() {
        super.onStop()
        model.incremental.observe(viewLifecycleOwner, {
            preferences.setIncrementalCount(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _increaseBinding = null
    }


}