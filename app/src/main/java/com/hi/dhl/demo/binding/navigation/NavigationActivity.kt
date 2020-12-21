package com.hi.dhl.demo.binding.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.demo.binding.R

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/21
 *     desc  :
 * </pre>
 */
class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, NavigationActivity::class.java))
        }
    }
}