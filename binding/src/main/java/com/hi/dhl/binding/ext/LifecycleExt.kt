package com.hi.dhl.binding

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */

fun Lifecycle.addObserver(destroyed: () -> Unit) {
    addObserver(LifecycleObserver(this, destroyed))
}

class LifecycleObserver(var lifecycle: Lifecycle?, val destroyed: () -> Unit) :
    LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val lifecycleState = source.lifecycle.currentState
        if (lifecycleState == Lifecycle.State.DESTROYED) {
            destroyed()
            lifecycle?.apply {
                removeObserver(this@LifecycleObserver)
                lifecycle = null
            }
        }
    }

}

fun Activity.registerActivityLifecycleCallbacks(destroyed: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        registerActivityLifecycleCallbacks(LifecycleCallbacks(destroyed))
    }
}

class LifecycleCallbacks(val destroyed: () -> Unit) :
    Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        destroyed()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            activity.unregisterActivityLifecycleCallbacks(this)
        }
    }
}

class LifecycleFragment : Fragment {
    lateinit var destroyed: () -> Unit

    constructor()

    @SuppressLint("ValidFragment")
    constructor(destroyed: () -> Unit) : this() {
        this.destroyed = destroyed
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyed()
    }
}
