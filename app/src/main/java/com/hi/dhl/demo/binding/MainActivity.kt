package com.hi.dhl.demo.binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModel()


    // DataBinding
    val binding: ActivityMainBinding by databind(R.layout.activity_main)
    // ViewBinding
//    val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            viewModel = mainViewModel
            textView.setText("Binding")
        }

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
        AppDialog(this).show()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}