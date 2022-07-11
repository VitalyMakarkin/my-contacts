package com.example.mycontacts.di

import com.example.mycontacts.ui.MainActivity
import com.example.mycontacts.ui.contactdetail.ContactDetailFragment
import com.example.mycontacts.ui.contactlist.ContactListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class, DataModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: ContactListFragment)
    fun inject(fragment: ContactDetailFragment)
}