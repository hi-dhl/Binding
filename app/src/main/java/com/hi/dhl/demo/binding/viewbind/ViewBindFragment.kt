package com.hi.dhl.demo.binding.viewbind

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.FragmentViewBindBinding
import com.hi.dhl.demo.binding.databinding.LayoutItem1Binding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class ViewBindFragment : Fragment(R.layout.fragment_view_bind) {


    val binding: FragmentViewBindBinding by viewbind()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvTitle.setText("直接使用布局中的控件")
            include.includeTvTitle.setText("使用 include 布局中的控件, 不包含 merge")
            btnDialog.setOnClickListener {
                this@ViewBindFragment.context?.let { ctx -> ViewBindDialog(ctx, lifecycle).show() }
            }
        }

        val bindingMerge = LayoutItem1Binding.bind(binding.root)
        with(bindingMerge) {
            mergeTvTitle.setText("使用 include 布局中的控件, 包含 merge")
        }

    }
}