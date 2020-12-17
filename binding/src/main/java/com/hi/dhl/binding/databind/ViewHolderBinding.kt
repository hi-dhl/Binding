package com.hi.dhl.binding.databind

import android.view.View
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
class ViewHolderBinding<T : ViewDataBinding>(
    private val classes: Class<T>,
    private val view: View
) : ReadOnlyProperty<RecyclerView.ViewHolder, T> {

    private var binding: T? = null

    override fun getValue(thisRef: RecyclerView.ViewHolder, property: KProperty<*>): T {
        return binding?.run {
            this
        } ?: let {
            val bind = DataBindingUtil.bind<T>(view) as T

            bind.apply { binding = this }
        }
    }

}