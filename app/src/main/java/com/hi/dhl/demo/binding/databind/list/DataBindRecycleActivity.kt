package com.hi.dhl.demo.binding.databind.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.databind
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.ActivityDataBindRecycleBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */
class DataBindRecycleActivity : AppCompatActivity() {

    private val binding: ActivityDataBindRecycleBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply { }
        // databinding 在 Fragment 中使用
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DataBindRecycleFragment())
            .commit()
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, DataBindRecycleActivity::class.java))
        }
    }
}