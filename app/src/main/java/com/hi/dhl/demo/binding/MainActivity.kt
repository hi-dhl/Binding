package com.hi.dhl.demo.binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModel()

    val binding: ActivityMainBinding by databind(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply { viewModel = mainViewModel }

        val timer = Timer()
        timer.schedule(
            object : TimerTask() {
                override fun run() {

                    mainViewModel.inputName.set("Time: " + System.currentTimeMillis())
                }
            },
            0, 500
        )

        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}