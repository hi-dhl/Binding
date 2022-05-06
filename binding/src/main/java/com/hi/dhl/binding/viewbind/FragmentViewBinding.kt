package com.hi.dhl.binding.viewbind

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.base.FragmentDelegate
import com.hi.dhl.binding.bindMethod
import com.hi.dhl.binding.inflateMethod
import java.lang.Exception
import kotlin.reflect.KProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/11
 *     desc  :
 * </pre>
 */
class FragmentViewBinding<T : ViewBinding>(
    classes: Class<T>,
    fragment: Fragment
) : FragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()
    private val bindView = classes.bindMethod()

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            /**
             * 检查目的，是为了防止在 onCreateView() or after onDestroyView() 使用 binding。
             * 另外在销毁之后，如果再次使用，由于 delegate property 会被再次初始化而出现的异常
             */
            if(thisRef.viewLifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
                Log.w(TAG,"cannot use binding in before onCreateView() or after onDestroyView() from 1.1.4. about [issue](https://github.com/hi-dhl/Binding/issues/31#issuecomment-1109733307)")
            }

            val bind: T
            if (thisRef.view == null) {
                // 这里为了兼容在 navigation 中使用 Fragment
                bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            } else {
                bind = bindView.invoke(null, thisRef.view) as T

            }

            return bind.apply { viewBinding = this }
        }
    }

    companion object {
        private val TAG = "FragmentViewBinding"
    }
}