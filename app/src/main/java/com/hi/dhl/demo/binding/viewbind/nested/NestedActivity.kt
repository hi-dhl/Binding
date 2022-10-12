package com.hi.dhl.demo.binding.viewbind.nested

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.ActivityNestedBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/13
 *     desc  :
 * </pre>
 */
class NestedActivity : AppCompatActivity() {
    val binding: ActivityNestedBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            addFragment()
        }
    }

    private fun addFragment() {
        val fragment1 = NestedFragment1()
        fragment1.resId = R.drawable.avatar

        val fragment2 = NestedFragment1()
        fragment2.resId = R.drawable.logo

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment1, fragment1)
            .add(R.id.fragment2, fragment2)
            .commit()
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, NestedActivity::class.java))
        }
    }
}