package com.hi.dhl.demo.binding.databind

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.FragmentDataBindBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
class DataBindFragment : Fragment(R.layout.fragment_data_bind) {

    private val binding: FragmentDataBindBinding by databind()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply { }
    }

}