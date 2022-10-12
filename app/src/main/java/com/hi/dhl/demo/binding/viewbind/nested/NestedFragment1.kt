package com.hi.dhl.demo.binding.viewbind.nested

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.FragmentNested1Binding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
class NestedFragment1 : Fragment(R.layout.fragment_nested1) {


    val binding: FragmentNested1Binding by viewbind()
    var activity: Activity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            activity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            image.setImageResource(R.drawable.avatar)
        }
    }

}