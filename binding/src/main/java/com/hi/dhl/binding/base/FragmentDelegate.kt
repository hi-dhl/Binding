package com.hi.dhl.binding.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.addObserver
import kotlin.properties.ReadOnlyProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
abstract class FragmentDelegate<T : ViewBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    protected var viewBinding: T? = null

    init {
        fragment.lifecycle.addObserver { destroyed() }
    }

    private fun destroyed() {
        viewBinding = null
    }
}