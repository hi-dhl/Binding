package com.hi.dhl.binding.databind

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.hi.dhl.binding.base.FragmentDelegate
import com.hi.dhl.binding.inflateMethod
import java.lang.Exception
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

class FragmentDataBinding<T : ViewDataBinding>(
    classes: Class<T>,
    val fragment: Fragment,
    private var block: (T.() -> Unit)? = null
) : FragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            try {
                /**
                 * 检查目的，是为了防止在 onCreateView() or after onDestroyView() 使用 binding。
                 * 另外在销毁之后，如果再次使用，由于 delegate property 会被再次初始化出现的异常
                 *
                 * 捕获这个异常的原因，是为了兼容之前的版本，防止因为升级，造成崩溃
                 */
                check(thisRef.viewLifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
                    "cannot use binding in before onCreateView() or after onDestroyView() from 1.1.4. about [issue](https://github.com/hi-dhl/Binding/issues/31#issuecomment-1109733307)"
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            val bind: T
            if (thisRef.view == null) {
                // 这里为了兼容在 navigation 中使用 Fragment
                bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            } else {
                bind = DataBindingUtil.bind(thisRef.view!!)!!
            }

            return bind.apply {
                viewBinding = this
                lifecycleOwner = fragment.viewLifecycleOwner
                block?.invoke(this)
                block = null
            }
        }
    }
}