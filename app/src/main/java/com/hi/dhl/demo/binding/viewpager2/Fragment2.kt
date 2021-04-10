package com.hi.dhl.demo.binding.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.MainViewModel
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.Fragment1Binding
import com.hi.dhl.demo.binding.databinding.Fragment2Binding
import com.hi.dhl.demo.binding.databinding.FragmentNav2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/21
 *     desc  :
 * </pre>
 */
class Fragment2 : Fragment() {

    val binding: Fragment2Binding by databind()
    val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.apply {
            lifecycleOwner = this@Fragment2
            mainViewModel = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            mainViewModel = viewModel
            viewModel.generateTimber()
        }

    }

}