package com.hi.dhl.binding.viewbind

import android.app.Activity
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.base.ActivityDelegate
import com.hi.dhl.binding.inflateMethod
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class ActivityViewBinding<T : ViewBinding>(
    classes: Class<T>,
    activity: Activity
) : ActivityDelegate<T>(activity) {

    private var layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {

            val bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            thisRef.setContentView(bind.root)
            return bind.apply { viewBinding = this }
        }
    }

}