package com.hi.dhl.demo.binding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databind.DatBindActivity
import com.hi.dhl.demo.binding.databinding.ActivityMainBinding
import com.hi.dhl.demo.binding.viewbind.ViewBindActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViews().forEach {
            it.setOnClickListener(this)
        }

    }

    override fun onClick(v: View) {
        with(binding) {
            when (v) {
                btnDataBind -> DatBindActivity.startActivity(this@MainActivity)
                btnViewBind -> ViewBindActivity.startActivity(this@MainActivity)
            }
        }
    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(btnDataBind, btnViewBind)
    }

}