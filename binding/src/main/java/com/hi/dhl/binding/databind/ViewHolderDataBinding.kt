package com.hi.dhl.binding.databind

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */
class ViewHolderDataBinding<T : ViewDataBinding>(
    classes: Class<T>,
    private var block: (T.() -> Unit)? = null
) : ReadOnlyProperty<RecyclerView.ViewHolder, T> {

    private var viewBinding: T? = null

    override fun getValue(thisRef: RecyclerView.ViewHolder, property: KProperty<*>): T {
        return viewBinding?.run {
            this
        } ?: let {

            val bind = DataBindingUtil.bind<T>(thisRef.itemView) as T
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