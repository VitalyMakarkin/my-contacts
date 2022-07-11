package com.example.mycontacts.ui.contactlist

import androidx.lifecycle.ViewModel
import com.example.mycontacts.data.ContactDataSource
import com.example.mycontacts.data.ContactSource
import com.example.mycontacts.model.Contact
import javax.inject.Inject

class ContactListViewModel @Inject constructor(private val contactSource: ContactSource) :
    ViewModel() {
    private var _contacts: List<Contact> = mutableListOf()
    val contacts: List<Contact>
        get() = _contacts

    init {
        _contacts = contactSource.getContacts()
    }
}