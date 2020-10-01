package com.fair.counter1234

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.fair.counter1234.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            setSupportActionBar(ToolBar)

            val fragmentAdapter = Adapter(supportFragmentManager)
            ViewPager.adapter = fragmentAdapter

            TabLayout.setupWithViewPager(ViewPager)

            TabLayout.getTabAt(0)?.setIcon(R.drawable.up)
            TabLayout.getTabAt(1)?.setIcon(R.drawable.down)


        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.counter_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.setting) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();return true
        }
        if (id == R.id.version) {
            Toast.makeText(this, "Version", Toast.LENGTH_SHORT).show();return true
        }

        return super.onOptionsItemSelected(item)
    }

}
