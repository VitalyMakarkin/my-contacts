package com.example.mycontacts

import android.content.Intent
import com.example.mycontacts.ui.MainActivity
import com.example.mycontacts.ui.contactdetail.ContactDetailFragment
import com.example.mycontacts.ui.contactlist.ContactListFragment
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Main() = ActivityScreen {
        Intent(it, MainActivity::class.java)
    }

    fun ContactList() = FragmentScreen {
        ContactListFragment()
    }

    fun ContactDetail(contactId: String) = FragmentScreen("Contact_$contactId") {
        ContactDetailFragment(contactId)
    }
}