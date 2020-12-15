package com.hi.dhl.binding.base

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.LifecycleFragment
import com.hi.dhl.binding.addObserver
import com.hi.dhl.binding.registerActivityLifecycleCallbacks
import kotlin.properties.ReadOnlyProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */

abstract class ActivityDelegate<T : ViewBinding>(
    activity: Activity
) : ReadOnlyProperty<Activity, T> {

    protected var viewBinding: T? = null
    private val LIFECYCLE_FRAGMENT_TAG = "com.hi.dhl.binding.lifecycle_fragment"

    init {
        when (activity) {
            is FragmentActivity -> activity.lifecycle.addObserver { destroyed() }
            is AppCompatActivity -> activity.lifecycle.addObserver { destroyed() }
            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    activity.registerActivityLifecycleCallbacks { destroyed() }
                }
            }
        }

    }

    /**
     * 当继承 Activity 且 Build.VERSION.SDK_INT < Build.VERSION_CODES.Q 以下的时候，
     * 会添加一个 空白的 Fragment, 当生命周期处于 onDestroy 时销毁数据
     */
    fun addLifecycleFragment(activity: Activity) {
        if (activity is FragmentActivity || activity is AppCompatActivity) return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) return

        val fragmentManager = activity.fragmentManager
        if (fragmentManager.findFragmentByTag(LIFECYCLE_FRAGMENT_TAG) == null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.add(LifecycleFragment { destroyed() }, LIFECYCLE_FRAGMENT_TAG).commit()
            fragmentManager.executePendingTransactions()
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}