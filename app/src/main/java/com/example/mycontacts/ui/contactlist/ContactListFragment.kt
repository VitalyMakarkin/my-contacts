package com.example.mycontacts.ui.contactlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.App
import com.example.mycontacts.databinding.FragmentContactListBinding
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ContactListFragment : Fragment() {
    @Inject
    lateinit var contactListViewModel: ContactListViewModel

    @Inject
    lateinit var router: Router

    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactListView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contacts = contactListViewModel.contacts
        contactListView = binding.contactList
        contactListView.layoutManager = LinearLayoutManager(context)
        contactListView.adapter = ItemAdapter(contacts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}