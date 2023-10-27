package com.example.myapplication.data.di

import com.example.myapplication.data.repository.googlelogin.GoogleLoginRepository
import com.example.myapplication.data.repository.googlelogin.GoogleLoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GoogleLoginRepository> { GoogleLoginRepositoryImpl(get()) }
}