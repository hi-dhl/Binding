package com.hi.dhl.binding.viewbind

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.addObserver
import com.hi.dhl.binding.bindMethod
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/11
 *     desc  :
 * </pre>
 */
class FragmentViewBindingDelegate<T : ViewBinding>(
    classes: Class<T>,
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    var viewBinding: T? = null
    val bindView = classes.bindMethod()

    init {
        fragment.lifecycle.addObserver { onDestroyed() }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            val bind = bindView.invoke(null, thisRef.view) as T
            return bind.apply { viewBinding = this }
        }
    }

    private fun onDestroyed() {
        viewBinding = null
    }
}