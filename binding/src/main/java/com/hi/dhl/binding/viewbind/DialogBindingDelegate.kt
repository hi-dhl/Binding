package com.hi.dhl.binding.viewbind

import android.app.Dialog
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.addObserver
import com.hi.dhl.binding.inflateMethod
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class DialogBindingDelegate<T : ViewBinding>(
    classes: Class<T>,
    lifecycle: Lifecycle? = null
) : ReadOnlyProperty<Dialog, T> {

    private var viewBinding: T? = null
    private var layoutInflater = classes.inflateMethod()

    init {
        lifecycle?.addObserver { destroyed() }
    }

    override fun getValue(thisRef: Dialog, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            thisRef.setContentView(bind.root)
            return bind
        }

    }

    private fun destroyed() {
        viewBinding = null
    }

}