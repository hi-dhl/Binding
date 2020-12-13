package com.hi.dhl.demo.binding.viewbind

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.AppDialog
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.FragmentMainBinding
import com.hi.dhl.demo.binding.databinding.LayoutItem1Binding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class MainFragment : Fragment(R.layout.fragment_main) {


    val binding: FragmentMainBinding by viewbind()


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvTitle.setText("直接使用布局中的控件")
            include.includeTvTitle.setText("使用 include 布局中的控件, 不包含 merge")
            btnDialog.setOnClickListener {
                this@MainFragment.context?.let { ctx -> AppDialog(ctx, lifecycle).show() }
            }
        }

        val bindingMerge = LayoutItem1Binding.bind(binding.root)
        with(bindingMerge) {
            mergeTvTitle.setText("使用 include 布局中的控件, 包含 merge")
        }

    }
}