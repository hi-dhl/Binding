package com.hi.dhl.demo.binding.viewbind

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databinding.LayoutViewCustomBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2021/1/14
 *     desc  :
 * </pre>
 */

class ViewBindCustomView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attr, defStyleAttr) {

    val binding: LayoutViewCustomBinding by viewbind()

    init {
        with(binding) {
            result.setText("这是 ViewGroup 通过 ViewBinding 绑定")
        }
    }
}