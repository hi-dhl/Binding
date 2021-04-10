package com.hi.dhl.demo.binding.viewpager2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.Fragment3Binding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/21
 *     desc  :
 * </pre>
 */
class Fragment3 : Fragment(R.layout.fragment3) {

    val binding: Fragment3Binding by viewbind()

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}