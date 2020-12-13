package com.hi.dhl.demo.binding.viewbind

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/13
 *     desc  :
 * </pre>
 */
class ViewBindActivity : AppCompatActivity() {

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, ViewBindActivity::class.java))
        }
    }
}