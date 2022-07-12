package com.example.mycontacts.ui.contactlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontacts.App
import com.example.mycontacts.Screens
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

    private val adapter: ItemAdapter by lazy {
        ItemAdapter { contact ->
            router.navigateTo(Screens.ContactDetail(contact.id))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.contactList) {
            adapter = this@ContactListFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        contactListViewModel.contacts.observe(viewLifecycleOwner) {
            adapter.submitDataset(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}