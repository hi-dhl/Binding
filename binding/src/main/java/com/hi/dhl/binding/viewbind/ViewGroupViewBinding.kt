package com.hi.dhl.binding.viewbind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.inflateMethod
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
    val inflater: LayoutInflater
) : ReadOnlyProperty<ViewGroup, T> {

    private var viewBinding: T? = null
    private val layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {
            val bind = layoutInflater.invoke(null, inflater) as T
            bind.apply {
                thisRef.addView(bind.root)
                viewBinding = this
            }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}