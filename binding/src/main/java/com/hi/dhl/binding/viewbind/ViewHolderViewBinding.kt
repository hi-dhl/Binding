package com.hi.dhl.binding.viewbind

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.bindMethod
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */
class ViewHolderViewBinding<T : ViewBinding>(
    classes: Class<T>
) : ReadOnlyProperty<RecyclerView.ViewHolder, T> {

    private var viewBinding: T? = null
    private val bindView = classes.bindMethod()

    override fun getValue(thisRef: RecyclerView.ViewHolder, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {
            val bind = bindView.invoke(null, thisRef.itemView) as T
            bind.apply { viewBinding = this }
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}