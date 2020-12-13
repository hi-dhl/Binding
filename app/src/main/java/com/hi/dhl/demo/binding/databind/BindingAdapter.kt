package com.hi.dhl.demo.binding.databind

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.hi.dhl.demo.binding.R
import com.hi.dhl.demo.binding.User

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
        textView.setText("@BindingAdapter + LiveData 示例 \n")
        textView.append("${name} - ${account}")
    }

}