package com.hi.dhl.binding.databind

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.base.FragmentDelegate
import com.hi.dhl.binding.inflateMethod
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class FragmentDataBinding<T : ViewDataBinding>(
    classes: Class<T>,
    fragment: Fragment,
    private var block: (T.() -> Unit)? = null
) : FragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            val bind: T
            if (thisRef.view == null) {
                // 这里为了兼容在 navigation 中使用 Fragment
                bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            } else {
                bind = DataBindingUtil.bind(thisRef.view!!)!!
            }

            return bind.apply {
                viewBinding = this
                block?.invoke(this)
                block = null
            }
        }
    }
}