package com.hi.dhl.binding.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
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

    init {
        when (activity) {
            is FragmentActivity -> activity.lifecycle.addObserver { destroyed() }
            is AppCompatActivity -> activity.lifecycle.addObserver { destroyed() }
            else -> activity.registerActivityLifecycleCallbacks { destroyed() }
        }

    }

    private fun destroyed() {
        viewBinding = null
    }
}