package com.hi.dhl.demo.binding.databind

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.LayoutViewCustomDataBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2021/1/14
 *     desc  :
 * </pre>
 */

class DataBindCustomView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attr, defStyleAttr) {

    val binding: LayoutViewCustomDataBinding by databind(R.layout.layout_view_custom_data)

    init {
        with(binding) {
            result.setText("这是 ViewGroup 通过 DataBinding 绑定")
        }
    }
}