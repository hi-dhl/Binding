package com.hi.dhl.binding.databind

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hi.dhl.binding.base.ActivityDelegate
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class ActivityDataBinding<T : ViewDataBinding>(
    activity: Activity,
    @LayoutRes val resId: Int,
) : ActivityDelegate<T>(activity) {

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind: T = DataBindingUtil.setContentView(thisRef, resId)
            return bind.apply { viewBinding = this }
        }
    }

}