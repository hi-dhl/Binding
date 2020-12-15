package com.hi.dhl.demo.binding.viewbind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.ActivityViewBindBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/13
 *     desc  :
 * </pre>
 */
class ViewBindActivity : AppCompatActivity() {
    val binding: ActivityViewBindBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            addFragment()
        }
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ViewBindFragment())
            .commit()
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, ViewBindActivity::class.java))
        }
    }
}