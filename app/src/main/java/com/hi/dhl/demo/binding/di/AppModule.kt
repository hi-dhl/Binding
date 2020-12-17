package com.hi.dhl.demo.binding.di

import com.hi.dhl.demo.binding.MainViewModel
import com.hi.dhl.demo.binding.databind.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/4/19
 *     desc  :
 * </pre>
 */
val viewModelsModule = module {
    viewModel { MainViewModel() }
    viewModel { ListViewModel() }
}

val appModules = listOf(viewModelsModule)