package com.hi.dhl.binding.viewbind

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.base.FragmentDelegate
import com.hi.dhl.binding.bindMethod
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/11
 *     desc  :
 * </pre>
 */
class FragmentViewBinding<T : ViewBinding>(
    classes: Class<T>,
    fragment: Fragment
) : FragmentDelegate<T>(fragment) {

    private val bindView = classes.bindMethod()

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            val bind = bindView.invoke(null, thisRef.view) as T
            return bind.apply { viewBinding = this }
        }
    }
}