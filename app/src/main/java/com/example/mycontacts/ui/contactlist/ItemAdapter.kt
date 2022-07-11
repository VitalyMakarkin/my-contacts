package com.example.mycontacts.ui.contactlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.R
import com.example.mycontacts.model.Contact

class ItemAdapter(private val dataset: List<Contact>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.contact_name)
        val phoneView: TextView = view.findViewById(R.id.contact_phone)
        val emailView: TextView = view.findViewById(R.id.contact_email)
        val imageView: ImageView = view.findViewById(R.id.contact_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameView.text = item.name
        holder.phoneView.text = item.phone
        holder.emailView.text = item.email
        holder.imageView.setImageResource(item.image)
        holder.itemView.setOnClickListener {
            // TODO Navigate to Contact Detail with contactId
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}