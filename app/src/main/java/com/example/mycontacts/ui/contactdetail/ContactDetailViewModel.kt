package com.example.mycontacts.ui.contactdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycontacts.data.ContactSource
import com.example.mycontacts.model.Contact
import javax.inject.Inject

class ContactDetailViewModel @Inject constructor(
    private val contactSource: ContactSource
) :
    ViewModel() {
    private var _contact: MutableLiveData<Contact> = MutableLiveData()
    val contact: LiveData<Contact> get() = _contact

    fun setContact(id: Int) {
        _contact.value = contactSource.getContactById(id)
    }
}