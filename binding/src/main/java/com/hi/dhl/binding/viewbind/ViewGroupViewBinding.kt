package com.hi.dhl.binding.viewbind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.inflateMethod
import com.hi.dhl.binding.inflateMethodWithViewGroup
import java.lang.reflect.Method
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */

class ViewGroupViewBinding<T : ViewBinding>(
    classes: Class<T>,
    val inflater: LayoutInflater,
    val viewGroup: ViewGroup? = null
) : ReadOnlyProperty<ViewGroup, T> {

    private var viewBinding: T? = null
    private var layoutInflater: Method

    init {
        if (viewGroup != null) {
            layoutInflater = classes.inflateMethodWithViewGroup()
        } else {
            layoutInflater = classes.inflateMethod()
        }
    }

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T
            if (viewGroup != null) {
                bind = layoutInflater.invoke(null, inflater, viewGroup) as T
            } else {
                bind = layoutInflater.invoke(null, inflater) as T
            }

            bind.apply {
                if (viewGroup == null) {
                    thisRef.addView(bind.root)
                }
                viewBinding = this
            }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}