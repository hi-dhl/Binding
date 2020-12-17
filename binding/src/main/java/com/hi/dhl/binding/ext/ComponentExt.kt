package com.hi.dhl.binding

import android.app.Activity
import android.app.Dialog
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.databind.ActivityDataBinding
import com.hi.dhl.binding.databind.DialogDataBinding
import com.hi.dhl.binding.databind.FragmenDataBinding
import com.hi.dhl.binding.viewbind.DialogViewBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */


inline fun <reified T : ViewDataBinding> Fragment.databind(noinline block: (T.() -> Unit)? = null) =
    FragmenDataBinding<T>(this, block)

inline fun <reified T : ViewDataBinding> Activity.databind(@LayoutRes resId: Int,noinline block: (T.() -> Unit)? = null) =
    ActivityDataBinding<T>(this, resId, block)

inline fun <reified T : ViewDataBinding> Dialog.databind(
    @LayoutRes resId: Int,
    noinline block: (T.() -> Unit)? = null
) = DialogDataBinding(
    classes = T::class.java,
    inflater = this.layoutInflater,
    resId = resId,
    block = block
)

inline fun <reified T : ViewDataBinding> Dialog.databind(
    @LayoutRes resId: Int,
    lifecycle: Lifecycle
) = DialogDataBinding(
    classes = T::class.java,
    inflater = this.layoutInflater,
    resId = resId,
    lifecycle = lifecycle
)

inline fun <reified T : ViewBinding> Activity.viewbind() =
    com.hi.dhl.binding.viewbind.ActivityViewBinding(T::class.java, this)

//inline fun <reified T : ViewBinding> AppCompatActivity.viewbind() =
//    com.hi.dhl.binding.viewbind.ActivityBindingDelegate(T::class.java, this)
//
//inline fun <reified T : ViewBinding> FragmentActivity.viewbind() =
//    com.hi.dhl.binding.viewbind.ActivityBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> Fragment.viewbind() =
    com.hi.dhl.binding.viewbind.FragmentViewBinding(T::class.java, this)

inline fun <reified T : ViewBinding> Dialog.viewbind() =
    DialogViewBinding(T::class.java)

inline fun <reified T : ViewBinding> Dialog.viewbind(lifecycle: Lifecycle) =
    DialogViewBinding(T::class.java, lifecycle)