package com.wizeline.communication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wizeline.communication.databinding.ClientListItemBinding

/**
 * [RecyclerView.Adapter] that can display a [Client].
 */
class ClientListRecyclerViewAdapter(
    private val values: List<Client> = listOf(),
    private val itemClicked: (Client) -> Unit = { }
) : RecyclerView.Adapter<ClientListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ClientListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.name
        holder.itemView.setOnClickListener {
            itemClicked(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ClientListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.clientId
        val contentView: TextView = binding.clientName

    }

}
