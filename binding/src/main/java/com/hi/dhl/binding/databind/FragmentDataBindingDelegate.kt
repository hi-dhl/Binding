package com.hi.dhl.binding.databind

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
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

class FragmentDataBindingDelegate<T : ViewBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    private var viewBinding: T? = null

    init {
        fragment.lifecycle.addObserver { onDestroyed() }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T = DataBindingUtil.bind(thisRef.view!!)!!
            return bind.apply { viewBinding = this }
        }
    }

    private fun onDestroyed() {
        viewBinding = null
    }
}