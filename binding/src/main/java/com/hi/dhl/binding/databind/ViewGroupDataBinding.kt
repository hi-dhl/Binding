package com.hi.dhl.binding.databind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */

class ViewGroupDataBinding<T : ViewBinding>(
    classes: Class<T>,
    @LayoutRes val resId: Int,
    val inflater: LayoutInflater,
    private var block: (T.() -> Unit)? = null
) : ReadOnlyProperty<ViewGroup, T> {

    private var viewBinding: T? = null

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {
            val bind = DataBindingUtil.inflate(inflater, resId, thisRef, true) as T
            val value = block
            bind.apply {
                viewBinding = this
                value?.invoke(this)
                block = null
            }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}