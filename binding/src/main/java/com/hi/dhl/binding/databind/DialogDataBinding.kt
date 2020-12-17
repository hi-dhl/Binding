package com.hi.dhl.binding.databind

import android.app.Dialog
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import com.hi.dhl.binding.base.DialogDelegate
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
class DialogDataBinding<T : ViewDataBinding>(
    val classes: Class<T>,
    val inflater: LayoutInflater,
    @LayoutRes val resId: Int,
    lifecycle: Lifecycle? = null,
    private var block: (T.() -> Unit)? = null
) : DialogDelegate<T>(lifecycle) {

    override fun getValue(thisRef: Dialog, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind = DataBindingUtil.bind<T>(inflater.inflate(resId, null))!! as T
            thisRef.setContentView(bind.root)
            return bind.apply {
                viewBinding = this
                block?.invoke(this)
                block = null
            }
        }

    }

}