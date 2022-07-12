package com.example.mycontacts.ui.contactlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycontacts.data.ContactSource
import com.example.mycontacts.model.Contact
import javax.inject.Inject

class ContactListViewModel @Inject constructor(
    private val contactSource: ContactSource
) :
    ViewModel() {
    private var _contacts: MutableLiveData<List<Contact>> = MutableLiveData()
    val contacts: LiveData<List<Contact>> get() = _contacts

    init {
        _contacts.postValue(contactSource.getContacts())
    }
}