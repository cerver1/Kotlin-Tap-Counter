package com.fair.counter1234
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fair.counter1234.databinding.DecreaseBinding

class Decrease: Fragment(R.layout.decrease){

    private var _decreaseBinding: DecreaseBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = DecreaseBinding.bind(view)
        _decreaseBinding = binding

        val shared = SharedPreferences(activity!!)
        val newValue = shared.retrieve("initValue")

        with(binding){


            if (newValue.isNullOrEmpty()) {
                txtDecreasing.text = getString(R.string.Init_Decrease)
                shared.save("initValue", "100")}
            else txtDecreasing.text = newValue

            txtDecreasing.setOnClickListener {

                val validation = txtDecreasing.text.toString()
                txtDecreasing.text = (validation.toInt() - 1).toString()
                fabResetDecreasing.setImageResource(R.drawable.reset)
            }

            fabResetDecreasing.setOnClickListener {

                if (txtDecreasing.text.toString().toInt() < shared.retrieve("initValue")!!.toInt()){
                    fabResetDecreasing.setImageResource(R.drawable.settings)
                    txtDecreasing.text = shared.retrieve("initValue")
                }
                else {initDialog(txtDecreasing)}

            }
        }

 }

    override fun onDestroyView() {

        _decreaseBinding = null
        super.onDestroyView()
            }

    @SuppressLint("InflateParams")
    private fun initDialog(decreased:TextView){

        val alert = AlertDialog.Builder(activity)
        alert.setTitle("Initial value")

        val cDialog = layoutInflater.inflate(R.layout.initialdialog, null)
        alert.setView(cDialog)
        val picker1 = cDialog.findViewById<NumberPicker>(R.id.num1st)
        val picker2 = cDialog.findViewById<NumberPicker>(R.id.num2nd)
        val picker3 = cDialog.findViewById<NumberPicker>(R.id.num3rd)
        val picker4 = cDialog.findViewById<NumberPicker>(R.id.num4th)

        picker1.minValue = 0; picker1.maxValue = 9
        picker2.minValue = 0; picker2.maxValue = 9
        picker3.minValue = 0; picker3.maxValue = 9
        picker4.minValue = 0; picker4.maxValue = 9

        alert.setPositiveButton("OK"){ _, _ ->

            val newValue = "${picker1.value}${picker2.value}${picker3.value}${picker4.value}"
            val formattedValue = newValue.removePrefix("000").removePrefix("00").removePrefix("0")
            SharedPreferences(activity!!).save("initValue",formattedValue)
            decreased.text = formattedValue

        }
        alert.setNegativeButton("CANCEL"){_, _ -> }

        alert.show()
        }
    }