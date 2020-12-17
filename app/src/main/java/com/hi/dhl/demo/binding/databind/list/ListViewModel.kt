package com.hi.dhl.demo.binding.databind.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/12/17
 *     desc  :
 * </pre>
 */
class ListViewModel : ViewModel() {

    private val _liveData = MutableLiveData<List<Product>>()
    val liveData: LiveData<List<Product>> = _liveData

    init {
        val data = mutableListOf<Product>()
        (1..15).forEach {
            val id = it
            val name = "公众号：ByteCode，这是通过 DataBinding 绑定的 item"
            data.add(Product(id, name))
        }
        _liveData.value = data
    }
}