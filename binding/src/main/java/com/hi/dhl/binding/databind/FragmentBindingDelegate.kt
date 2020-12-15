package com.hi.dhl.binding.databind

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.addObserver
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class FragmentBindingDelegate<T : ViewDataBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    private var viewBinding: T? = null

    init {
        fragment.lifecycle.addObserver { destroyed() }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T = DataBindingUtil.bind(thisRef.view!!)!!
            return bind.apply { viewBinding = this }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}