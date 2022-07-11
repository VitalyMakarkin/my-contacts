package com.example.mycontacts.ui.contactdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycontacts.App
import com.example.mycontacts.databinding.FragmentContactDetailBinding
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ContactDetailFragment() : Fragment() {
    @Inject
    lateinit var contactDetailViewModel: ContactDetailViewModel

    @Inject
    lateinit var router: Router

    val contactId: Int
        get() = arguments!!.getInt(ARG_CONTACT)

    private var _binding: FragmentContactDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        // TODO: Pass contactId to contactDetailViewModel
        // TODO: But it may not be in this method, because there is only one instance?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contact = contactDetailViewModel.contact
        binding.contactName.text = contact.name
        binding.contactPhone.text = "Phone: ${contact.phone}"
        binding.contactEmail.text = "Email: ${contact.email}"
        binding.contactImage.setImageResource(contact.image)
    }

    companion object {
        private const val ARG_CONTACT = "arg_contact"

        fun getNewInstance(contactId: Int): ContactDetailFragment {
            return ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CONTACT, contactId)
                }
            }
        }
    }
}