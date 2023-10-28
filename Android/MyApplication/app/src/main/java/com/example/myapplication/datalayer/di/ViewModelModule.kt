package com.example.myapplication.datalayer.di

import com.example.myapplication.viewlayer.googlelogin.viewmodel.GoogleLoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GoogleLoginViewModel(get()) }
}