package com.hi.dhl.demo.binding.brvah

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.hi.dhl.binding.viewbind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databind.list.ListViewModel
import com.hi.dhl.demo.binding.databind.list.Product
import com.hi.dhl.demo.binding.databinding.ActivityBrvahBinding
import com.hi.dhl.demo.binding.databinding.RecycleItemProductBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2021/5/15
 *     desc  :
 *
 *     因有小伙伴反馈在开源库 BRVAH 中无法使用，所以单独写了一个如何在 BRVAH 中使用的例子
 *     issue: https://github.com/hi-dhl/Binding/issues/24
 *
 * </pre>
 */
class BRVAHActivity : AppCompatActivity() {

    private val binding: ActivityBrvahBinding by viewbind()
    private val viewModel: ListViewModel by viewModel()
    private val adapter: BRVAHAdapter by lazy { BRVAHAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            recyclerView.adapter = adapter
        }

        viewModel.liveData.observe(this@BRVAHActivity) {
            adapter.addData(it)
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, BRVAHActivity::class.java))
        }
    }
}

class BRVAHAdapter : BaseQuickAdapter<Product, BRVAHViewHolder>(0) {
    override fun convert(holder: BRVAHViewHolder, item: Product) {
        holder.bindData(item)
    }

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BRVAHViewHolder {
        val view = inflateView(parent, viewType)
        return BRVAHViewHolder(view)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }

    override fun getDefItemViewType(position: Int): Int = R.layout.recycle_item_product
}


class BRVAHViewHolder(view: View) : BaseViewHolder(view) {
    val binding: RecycleItemProductBinding by viewbind()

    fun bindData(data: Product) {
        binding.apply {
            product = data
            executePendingBindings()
        }
    }

}