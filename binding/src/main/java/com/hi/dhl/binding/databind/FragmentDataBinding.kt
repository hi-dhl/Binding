package com.hi.dhl.binding.databind

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.base.FragmentDelegate
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class FragmenDataBinding<T : ViewDataBinding>(
    fragment: Fragment,
    private val block: (T.() -> Unit)? = null
) : FragmentDelegate<T>(fragment) {

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T = DataBindingUtil.bind(thisRef.requireView())!!
            return bind.apply {
                viewBinding = this
                block?.invoke(this)
            }
        }
    }
}