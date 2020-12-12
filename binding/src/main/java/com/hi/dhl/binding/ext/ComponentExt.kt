package com.hi.dhl.binding

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.databind.ActivityDataBindingDelegate
import com.hi.dhl.binding.databind.FragmentDataBindingDelegate
import com.hi.dhl.binding.viewbind.ActivityViewBindingDelegate
import com.hi.dhl.binding.viewbind.FragmentViewBindingDelegate

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/10
 *     desc  :
 * </pre>
 */

inline fun <reified T : ViewDataBinding> Fragment.databind() =
    FragmentDataBindingDelegate<T>(this)

inline fun <reified T : ViewDataBinding> Activity.databind(@LayoutRes resId: Int) =
    ActivityDataBindingDelegate<T>(this, resId)

inline fun <reified T : ViewBinding> Activity.viewbind() =
    ActivityViewBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> AppCompatActivity.viewbind() =
    ActivityViewBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> FragmentActivity.viewbind() =
    ActivityViewBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> Fragment.viewbind() =
    FragmentViewBindingDelegate(T::class.java, this)