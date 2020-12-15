package com.hi.dhl.demo.binding.databind

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.lifecycle.Lifecycle
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.DialogDataBindingBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class DataBindDialog(context: Context, lifecycle: Lifecycle) :
    Dialog(context, R.style.AppDialog) {

    val binding: DialogDataBindingBinding by databind(R.layout.dialog_data_binding, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding.apply { result.setText("DataBindDialog") }
    }
}