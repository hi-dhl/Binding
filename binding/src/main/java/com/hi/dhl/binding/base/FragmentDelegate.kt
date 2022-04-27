package com.hi.dhl.binding.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.observerWhenCreated
import kotlin.properties.ReadOnlyProperty

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
abstract class FragmentDelegate<T : ViewBinding>(
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    protected var viewBinding: T? = null

    init {

        // 详情查看 [issue][https://github.com/hi-dhl/Binding/issues/31#issuecomment-1109729949]
        fragment.lifecycle.observerWhenCreated {
            val fragmentManager = fragment.requireFragmentManager()
            fragmentManager.registerFragmentLifecycleCallbacks(object :
                FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentViewDestroyed(fm, f)
                    // 检查 fragment 的目的，为了防止类似于加载多个 Fragment 场景销毁的时候，出现不必要的异常
                    if (f == fragment) {
                        destroyed()
                        fragmentManager.unregisterFragmentLifecycleCallbacks(this)
                    }

                }
            }, false)
        }

    }

    private fun destroyed() {
        viewBinding = null
    }
}