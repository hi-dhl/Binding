package com.hi.dhl.binding

import android.view.LayoutInflater
import android.view.View

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/11
 *     desc  :
 * </pre>
 */

const val INFLATE_NAME = "inflate"
const val BIND_NAME = "bind"

fun <T> Class<T>.inflateMethod() = getMethod(INFLATE_NAME, LayoutInflater::class.java)

fun <T> Class<T>.bindMethod() = getMethod(BIND_NAME, View::class.java)