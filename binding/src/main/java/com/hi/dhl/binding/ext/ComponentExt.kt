package com.hi.dhl.binding

import android.app.Activity
import android.app.Dialog
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.databind.ActivityBindingDelegate
import com.hi.dhl.binding.databind.DialogDataBindingDelegate
import com.hi.dhl.binding.databind.FragmentBindingDelegate

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */


inline fun <reified T : ViewDataBinding> Fragment.databind() =
    FragmentBindingDelegate<T>(this)

inline fun <reified T : ViewDataBinding> Activity.databind(@LayoutRes resId: Int) =
    ActivityBindingDelegate<T>(this, resId)

inline fun <reified T : ViewDataBinding> Dialog.databind(
    @LayoutRes resId: Int,
    lifecycle: Lifecycle
) = DialogDataBindingDelegate(
    classes = T::class.java,
    inflater = this.layoutInflater,
    resId = resId
)

inline fun <reified T : ViewBinding> Activity.viewbind() =
    com.hi.dhl.binding.viewbind.ActivityBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> AppCompatActivity.viewbind() =
    com.hi.dhl.binding.viewbind.ActivityBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> FragmentActivity.viewbind() =
    com.hi.dhl.binding.viewbind.ActivityBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> Fragment.viewbind() =
    com.hi.dhl.binding.viewbind.FragmentBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> Dialog.viewbind() =
    com.hi.dhl.binding.viewbind.DialogBindingDelegate(T::class.java)

inline fun <reified T : ViewBinding> Dialog.viewbind(lifecycle: Lifecycle) =
    com.hi.dhl.binding.viewbind.DialogBindingDelegate(T::class.java, lifecycle)