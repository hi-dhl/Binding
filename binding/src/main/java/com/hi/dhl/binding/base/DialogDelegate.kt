package com.hi.dhl.binding.base

import android.app.Dialog
import androidx.lifecycle.Lifecycle
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
abstract class DialogDelegate<T : ViewBinding>(
    lifecycle: Lifecycle? = null
) : ReadOnlyProperty<Dialog, T> {

    protected var viewBinding: T? = null

    init {
        lifecycle?.addObserver { destroyed() }
    }

    fun destroyed() {
        viewBinding = null
    }
}