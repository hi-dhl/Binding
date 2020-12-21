package com.hi.dhl.demo.binding.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.MainViewModel
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.FragmentNav2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/21
 *     desc  :
 * </pre>
 */
class FragmentNav2 : Fragment() {

    val binding: FragmentNav2Binding by databind()
    val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.apply {
            lifecycleOwner = this@FragmentNav2
            mainViewModel = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.generateTimber()
        binding.btnJump.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragmentNav2_to_fragmentNav3)
        }
    }

}