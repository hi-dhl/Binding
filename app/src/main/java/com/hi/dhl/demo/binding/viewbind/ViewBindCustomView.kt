package com.hi.dhl.demo.binding.viewbind

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databinding.LayoutMergeItemBinding
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

    lateinit var onDialogClickListener: OnDialogClickListener

    // 当根布局为 merge 标签，使用此方法进行初始化
    val binding: LayoutViewCustomBinding by viewbind(this)

    // 当根布局是非 merge 标签，使用此方法进行初始化
//    val binding: LayoutViewCustomBinding by viewbind()

    init {
        with(binding) {
            result.setText("这是 ViewGroup 通过 ViewBinding 绑定")
            result.setOnClickListener {
                if (::onDialogClickListener.isInitialized) {
                    onDialogClickListener.onClick()
                }
            }

            LayoutMergeItemBinding.bind(root)
                .mergeTvTitle.setText("在 ViewGroup 中使用 merge 标签")
        }
    }

    fun setDialogClickListener(onDialogClickListener: OnDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener
    }

    interface OnDialogClickListener {
        fun onClick()
    }
}