package com.example.mycontacts.ui.contactlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.R
import com.example.mycontacts.model.Contact

class ItemAdapter(
    private val onContactClick: (Contact) -> Unit
) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var dataset: List<Contact> = emptyList()

    fun submitDataset(contacts: List<Contact>) {
        dataset = contacts
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView = view.findViewById(R.id.contact_name)
        private val phoneView: TextView = view.findViewById(R.id.contact_phone)
        private val emailView: TextView = view.findViewById(R.id.contact_email)
        private val imageView: ImageView = view.findViewById(R.id.contact_image)

        fun bind(contact: Contact) {
            nameView.text = contact.name
            phoneView.text = contact.phone
            emailView.text = contact.email
            imageView.setImageResource(contact.image)
            itemView.setOnClickListener {
                onContactClick(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}