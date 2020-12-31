package com.hi.dhl.demo.binding.viewbind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databinding.ActivityIncludeViewBindBinding
import com.hi.dhl.demo.binding.databinding.LayoutMergeItemBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/31
 *     desc  :
 * </pre>
 */
class ViewBindIncludeActivity : AppCompatActivity() {

    val binding: ActivityIncludeViewBindBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            tvTitle.setText("直接使用布局中的控件")

            // include without merge
            include.includeTvTitle.setText("使用 include 布局中的控件, 不包含 merge")

            // include
            LayoutMergeItemBinding.bind(root)
                .mergeTvTitle.setText("使用 include 布局中的控件, 包含 merge")
        }
    }

    companion object {

        fun startActivtiy(activity: Activity) {
            activity.startActivity(Intent(activity, ViewBindIncludeActivity::class.java))
        }

    }
}