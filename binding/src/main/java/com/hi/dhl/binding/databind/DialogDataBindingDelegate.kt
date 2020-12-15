package com.hi.dhl.binding.databind

import android.app.Dialog
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import com.hi.dhl.binding.addObserver
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
class DialogDataBindingDelegate<T : ViewDataBinding>(
    val classes: Class<T>? = null,
    val inflater: LayoutInflater,
    @LayoutRes val resId: Int,
    lifecycle: Lifecycle? = null
) : ReadOnlyProperty<Dialog, T> {

    private var viewBinding: T? = null

    init {
        lifecycle?.addObserver { destroyed() }
    }

    override fun getValue(thisRef: Dialog, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind = DataBindingUtil.bind<T>(inflater.inflate(resId, null))!! as T
            thisRef.setContentView(bind.root)
            return bind.apply { viewBinding = this }

        }

    }

    private fun destroyed() {
        viewBinding = null
    }


}