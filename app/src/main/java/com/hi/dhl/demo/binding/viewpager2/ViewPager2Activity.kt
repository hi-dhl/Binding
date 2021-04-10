package com.hi.dhl.demo.binding.viewpager2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.ActivityViewpagerBinding


/**
 * <pre>
 *     author: dhl
 *     date  : 2021/4/10
 *     desc  :
 * </pre>
 */
class ViewPager2Activity : AppCompatActivity(), View.OnClickListener {
    val binding: ActivityViewpagerBinding by viewbind()
    var fragment1: Fragment1 = Fragment1()
    var fragment2: Fragment2 = Fragment2()
    var fragment3: Fragment3 = Fragment3()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.container, fragment3)
            fragmentTransaction.add(R.id.container, fragment2)
            fragmentTransaction.add(R.id.container, fragment1)
            hideFragment(fragmentTransaction)
            fragmentTransaction.show(fragment1)
            fragmentTransaction.commit()

            getViews().forEach {
                it.setOnClickListener(this@ViewPager2Activity)
            }
        }

    }

    private fun getViews() = with(binding) {
        arrayListOf<View>(
            tab1,
            tab2,
            tab3
        )
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, ViewPager2Activity::class.java))
        }
    }

    override fun onClick(v: View) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        hideFragment(fragmentTransaction)
        with(binding) {
            when (v) {
                tab1 -> {
                    fragmentTransaction.show(fragment1)
                }
                tab2 -> {
                    fragmentTransaction.show(fragment2)
                }
                tab3 -> fragmentTransaction.show(fragment3)
                else -> {
                }
            }
        }
        fragmentTransaction.commitNow()
    }

    private fun hideFragment(fragmentTransaction: FragmentTransaction) {
        getViews().forEach {
            fragmentTransaction.hide(fragment1)
            fragmentTransaction.hide(fragment2)
            fragmentTransaction.hide(fragment3)

        }
    }

}