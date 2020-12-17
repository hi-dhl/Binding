package com.hi.dhl.demo.binding.databind

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.User
import com.hi.dhl.demo.binding.databind.list.Product
import com.hi.dhl.demo.binding.databind.list.ProductAdapter

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/13
 *     desc  :
 * </pre>
 */

@BindingAdapter("bindingImage")
fun bindingImage(imageView: ImageView, url: String?) {
    imageView.load(url) {
        crossfade(true)
        placeholder(R.mipmap.ic_launcher_round)
    }
}

@BindingAdapter("bindingLiveData")
fun bindingLiveData(textView: TextView, user: User?) {
    user?.apply {
        textView.setText("@BindingAdapter + LiveData + parcelize 示例 \n")
        textView.append("${name} - ${account}")
    }

}

@BindingAdapter("bindList")
fun bindAdapterList(recyclerView: RecyclerView, data: List<Product>?) {
    val adapter = recyclerView.adapter as? ProductAdapter
        ?: throw RuntimeException("adapter must bu not null")
    data?.let {
        adapter.submitList(it)
        adapter.notifyDataSetChanged()
    }
}