package com.hi.dhl.demo.binding.databind.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.FragmentDataBindRecycleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/15
 *     desc  :
 * </pre>
 */
class DataBindRecycleFragment : Fragment(R.layout.fragment_data_bind_recycle) {

    private val listViewModel: ListViewModel by viewModel()

    private val binding: FragmentDataBindRecycleBinding by databind()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = listViewModel
            adapter = ProductAdapter()
            lifecycleOwner = this@DataBindRecycleFragment
        }
    }

}