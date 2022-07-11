package com.example.mycontacts.ui.contactdetail

import androidx.lifecycle.ViewModel
import com.example.mycontacts.data.ContactDataSource
import com.example.mycontacts.data.ContactSource
import com.example.mycontacts.model.Contact
import javax.inject.Inject

class ContactDetailViewModel @Inject constructor(private val contactSource: ContactSource) :
    ViewModel() {
    // TODO Get contactId from Contact List Item
    private var _contact: Contact = contactSource.getContactById(0)
    val contact: Contact
        get() = _contact
}