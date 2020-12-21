package com.hi.dhl.demo.binding.databind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.MainViewModel
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databind.list.DataBindRecycleActivity
import com.hi.dhl.demo.binding.databinding.ActivityDataBindBinding
import com.hi.dhl.demo.binding.navigation.NavigationActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/13
 *     desc  :
 * </pre>
 */
class DatBindActivity : AppCompatActivity(), View.OnClickListener {

    val viewModel: MainViewModel by viewModel()

    val binding: ActivityDataBindBinding by databind(R.layout.activity_data_bind)

    // 第二种用法 或者通过下列方式绑定数据， 所有使用 DataBinding 绑定的地方都可以使用这种方式
//    val binding: ActivityDataBindBinding by databind(R.layout.activity_data_bind) {
//        val account = Account()
//        account.name = "test"
//        this.account = account
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            account = viewModel.bindAccount()
            mainViewModel = viewModel
            lifecycleOwner = this@DatBindActivity
        }

        getViews().forEach {
            it.setOnClickListener(this)
        }
    }


    override fun onClick(v: View) {
        val lifecycle = this.lifecycle
        with(binding) {
            when (v) {
                btnBindRandom -> viewModel.generateTimber()
                btnBindAdapter -> viewModel.bindUser()
                btnDialog -> DataBindDialog(this@DatBindActivity, lifecycle).show()
                btnRecycle -> DataBindRecycleActivity.startActivity(this@DatBindActivity)
                btnNavigation -> NavigationActivity.startActivity(this@DatBindActivity)
            }
        }
    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(btnBindRandom, btnBindAdapter, btnDialog, btnRecycle, btnNavigation)
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, DatBindActivity::class.java))
        }
    }

}