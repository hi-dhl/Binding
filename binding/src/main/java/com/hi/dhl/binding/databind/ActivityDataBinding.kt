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
    val activity: Activity,
    @LayoutRes val resId: Int,
    private var block: (T.() -> Unit)? = null
) : ActivityDelegate<T>(activity) {

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {
            // 当继承 Activity 且 Build.VERSION.SDK_INT < Build.VERSION_CODES.Q 时触发
            addLifecycleFragment(activity)

            // 获取 ViewDataBinding
            val bind: T = DataBindingUtil.setContentView(thisRef, resId)
            return bind.apply {
                viewBinding = this
                block?.invoke(this)
                block = null
            }
        }
    }

}