package com.example.mycontacts.data

import com.example.mycontacts.R
import com.example.mycontacts.model.Contact
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class ContactDataSource(): ContactSource {
    private val contacts: List<Contact> = listOf(
        Contact(0, "Max", "+7 (900) 444-44-00", "max@email.com", R.drawable.ic_contact_blue),
        Contact(1, "Ann", "+7 (900) 444-44-01", "ann@email.com", R.drawable.ic_contact_yellow),
        Contact(2, "Alex", "+7 (900) 444-44-02", "alex@email.com", R.drawable.ic_contact_red),
        Contact(3, "Mark", "+7 (900) 444-44-03", "mark@email.com", R.drawable.ic_contact_orange),
        Contact(4, "Jack", "+7 (900) 444-44-04", "anthony@email.com", R.drawable.ic_contact_green),
        Contact(5, "Clark", "+7 (900) 444-44-05", "clark@email.com", R.drawable.ic_contact_blue),
        Contact(6, "Janet", "+7 (900) 444-44-06", "janet@email.com", R.drawable.ic_contact_red),
        Contact(7, "Sam", "+7 (900) 444-44-07", "sam@email.com", R.drawable.ic_contact_orange),
        Contact(8, "Will", "+7 (900) 444-44-08", "will@email.com", R.drawable.ic_contact_yellow),
    )

    override fun getContacts(): List<Contact> {
        return contacts
    }

    override fun getContactById(id: Int): Contact {
        return contacts.single { it.id == id }
    }
}