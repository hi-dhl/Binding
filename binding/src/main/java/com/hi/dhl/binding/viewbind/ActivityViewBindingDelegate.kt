package com.hi.dhl.binding.viewbind

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.addObserver
import com.hi.dhl.binding.inflateMethod
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

class ActivityViewBindingDelegate<T : ViewBinding>(
    classes: Class<T>,
    activity: Activity
) : ReadOnlyProperty<Activity, T> {

    private var viewBinding: T? = null

    private var layoutInflater = classes.inflateMethod()

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

            val bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            thisRef.setContentView(bind.root)
            return bind.apply { viewBinding = this }

        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}