package com.example.mycontacts.data

import com.example.mycontacts.model.Contact

interface ContactSource {
    fun getContacts(): List<Contact>
    fun getContactById(id: Int): Contact
}