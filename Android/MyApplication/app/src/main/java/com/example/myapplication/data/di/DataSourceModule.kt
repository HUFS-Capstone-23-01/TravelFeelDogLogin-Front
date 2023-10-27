package com.example.myapplication.data.di

import com.example.myapplication.data.repository.googlelogin.datasource.GoogleLoginDataSource
import com.example.myapplication.data.repository.googlelogin.datasource.GoogleLoginDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<GoogleLoginDataSource> { GoogleLoginDataSourceImpl(get()) }
}