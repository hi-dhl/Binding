package com.hi.dhl.binding.databind

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.addObserver
import com.hi.dhl.binding.registerActivityLifecycleCallbacks
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class ActivityDataBindingDelegate<T : ViewBinding>(
    activity: Activity,
    @LayoutRes val resId: Int = -1,
) : ReadOnlyProperty<Activity, T> {

    private var viewBinding: T? = null

    init {
        when (activity) {
            is FragmentActivity -> activity.lifecycle.addObserver { destroyed() }
            is AppCompatActivity -> activity.lifecycle.addObserver { destroyed() }
            else -> activity.registerActivityLifecycleCallbacks { destroyed() }
        }
    }

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T = DataBindingUtil.setContentView(thisRef, resId)
            return bind.apply { viewBinding = this }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}