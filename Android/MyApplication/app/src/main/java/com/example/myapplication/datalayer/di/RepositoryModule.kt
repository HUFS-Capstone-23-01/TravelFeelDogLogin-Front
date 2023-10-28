package com.example.myapplication.datalayer.di

import com.example.myapplication.datalayer.repository.googlelogin.GoogleLoginRepository
import com.example.myapplication.datalayer.repository.googlelogin.GoogleLoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GoogleLoginRepository> { GoogleLoginRepositoryImpl(get()) }
}