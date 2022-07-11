package com.example.mycontacts.di

import com.example.mycontacts.data.ContactDataSource
import com.example.mycontacts.data.ContactSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideContactSource(): ContactSource {
        return ContactDataSource()
    }
}