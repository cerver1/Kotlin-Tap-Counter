package com.fair.counter1234

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = Adapter(supportFragmentManager)
        ViewPager.adapter = fragmentAdapter

        TabLayout.setupWithViewPager(ViewPager)

        TabLayout.getTabAt(0)!!.setIcon(R.drawable.up)
        TabLayout.getTabAt(1)!!.setIcon(R.drawable.down)

    }
}
