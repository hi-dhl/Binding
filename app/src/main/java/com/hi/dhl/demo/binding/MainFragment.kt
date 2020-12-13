package com.hi.dhl.demo.binding

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.databind
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/12
 *     desc  :
 * </pre>
 */
//class MainFragment : Fragment(R.layout.fragment_main) {
//    val binding: FragmentMainBinding by databind()
//    val mainViewModel: MainViewModel by viewModel()
//
//    val handler = Handler(object : Handler.Callback {
//        override fun handleMessage(msg: Message): Boolean {
////            mainViewModel.inputName.set("Time: " + System.currentTimeMillis())
//            return true
//        }
//    })
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.apply { viewModel = mainViewModel }
//
//        val timer = Timer()
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                handler.sendEmptyMessage(100)
//            }
//        }, 0, 500)
//    }
//}