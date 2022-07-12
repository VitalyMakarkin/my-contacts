package com.example.mycontacts.ui.contactdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycontacts.App
import com.example.mycontacts.databinding.FragmentContactDetailBinding
import javax.inject.Inject

class ContactDetailFragment() : Fragment() {
    @Inject
    lateinit var contactDetailViewModel: ContactDetailViewModel

    private val contactId: Int
        get() = arguments!!.getInt(ARG_CONTACT)

    private var _binding: FragmentContactDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        contactDetailViewModel.setContact(contactId)
        with(contactDetailViewModel.contact) {
            binding.contactName.text = name
            binding.contactPhone.text = "Phone: $phone"
            binding.contactEmail.text = "Email: $email"
            binding.contactImage.setImageResource(image)
        }
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