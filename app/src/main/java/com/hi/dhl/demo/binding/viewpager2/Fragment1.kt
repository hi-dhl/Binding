package com.hi.dhl.demo.binding.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.databinding.Fragment1Binding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/21
 *     desc  :
 * </pre>
 */
class Fragment1 : Fragment() {

    val binding: Fragment1Binding by viewbind()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewpager2.adapter = object : FragmentStateAdapter(this@Fragment1.requireActivity()) {
                override fun getItemCount() = 2

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> Fragment4()
                        else -> Fragment5()
                    }
                }
            }

        }
    }

}