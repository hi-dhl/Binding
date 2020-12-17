package com.hi.dhl.demo.binding.databind.list

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.hi.dhl.binding.databind
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.databinding.RecycleItemProductBinding
import com.hi.dhl.jdatabinding.DataBindingListAdapter
import com.hi.dhl.jdatabinding.DataBindingViewHolder

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */
class ProductAdapter : DataBindingListAdapter<Product>(Product.CALLBACK) {

    override fun layout(position: Int): Int = R.layout.recycle_item_product

    override fun viewHolder(layout: Int, view: View): DataBindingViewHolder<Product> =
        ProductViewHolder(view)
}

class ProductViewHolder(view: View) : DataBindingViewHolder<Product>(view) {

    val binding: RecycleItemProductBinding by databind(view)

    override fun bindData(data: Product, position: Int) {
        binding.apply {
            product = data
            executePendingBindings()
        }
    }
}

data class Product(val id: Int, val name: String) {
    companion object {
        val CALLBACK: DiffUtil.ItemCallback<Product> = object : DiffUtil.ItemCallback<Product>() {
            // 判断两个Objects 是否代表同一个item对象， 一般使用Bean的id比较
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
                oldItem.id == newItem.id

            // 判断两个Objects 是否有相同的内容。
            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean = true
        }
    }
}