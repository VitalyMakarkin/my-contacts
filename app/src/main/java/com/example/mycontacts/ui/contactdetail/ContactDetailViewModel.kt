package com.example.mycontacts.ui.contactdetail

import androidx.lifecycle.ViewModel
import com.example.mycontacts.data.ContactSource
import com.example.mycontacts.model.Contact
import javax.inject.Inject

class ContactDetailViewModel @Inject constructor(private val contactSource: ContactSource) :
    ViewModel() {
    private lateinit var _contact: Contact
    val contact: Contact
        get() = _contact

    fun setContact(id: Int) {
        _contact = contactSource.getContactById(id)
    }
}