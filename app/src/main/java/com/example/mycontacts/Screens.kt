package com.example.mycontacts

import com.example.mycontacts.ui.contactdetail.ContactDetailFragment
import com.example.mycontacts.ui.contactlist.ContactListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun ContactList() = FragmentScreen {
        ContactListFragment()
    }

    fun ContactDetail(contactId: Int) = FragmentScreen("Contact_$contactId") {
        ContactDetailFragment.getNewInstance(contactId)
    }
}