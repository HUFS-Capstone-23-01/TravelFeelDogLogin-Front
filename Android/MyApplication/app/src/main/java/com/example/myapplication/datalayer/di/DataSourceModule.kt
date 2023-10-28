package com.example.myapplication.datalayer.di

import com.example.myapplication.datalayer.repository.googlelogin.datasource.GoogleLoginDataSource
import com.example.myapplication.datalayer.repository.googlelogin.datasource.GoogleLoginDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<GoogleLoginDataSource> { GoogleLoginDataSourceImpl(get()) }
}