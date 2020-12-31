package com.hi.dhl.demo.binding.databind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewStubProxy
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.ActivityViewStubBinding
import com.hi.dhl.demo.binding.databinding.ViewStubBinding
import com.hi.dhl.demo.binding.databinding.ViewStubDataBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/31
 *     desc  :
 * </pre>
 */
class BindViewStubActivity : AppCompatActivity() {

    val binding: ActivityViewStubBinding by databind(R.layout.activity_view_stub)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewStub.setOnInflateListener { stub, inflated ->

            // ViewBinding
            val viewStub: ViewStubBinding = ViewStubBinding.bind(inflated)
            viewStub.tvTitle.setText("使用 ViewStub 加载 ViewBinding 布局")

        }

        binding.viewStubData.setOnInflateListener { stub, inflated ->

            // DataBinding
            val dataViewStub: ViewStubDataBinding = DataBindingUtil.bind(inflated)!!
            dataViewStub.tvTitle.setText("使用 ViewStub 加载 DataBinding 布局")
        }

        inflateLayout(binding.viewStub)
        inflateLayout(binding.viewStubData)
    }

    private fun inflateLayout(viewStubProxy: ViewStubProxy) {
        if (!viewStubProxy.isInflated) {
            viewStubProxy.viewStub!!.inflate()
        }
    }

    companion object {

        fun startActivtiy(activity: Activity) {
            activity.startActivity(Intent(activity, BindViewStubActivity::class.java))
        }

    }

}