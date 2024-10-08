package com.trios2024amrk.swisschalet.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trios2024amrk.swisschalet.TaskList
import com.trios2024amrk.swisschalet.databinding.ListSelectionViewHolderBinding

class ListSelectionRecyclerViewAdapter(private val lists :
    MutableList<TaskList>): RecyclerView.Adapter<ListSelectionViewHolder>()
{
     //val listTitles = arrayOf("Title1", "Title2")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder
    {
        val binding = ListSelectionViewHolderBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ListSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int
    {
        return lists.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int)
    {
        holder.binding.itemNumber.text = (position + 1).toString()
        holder.binding.itemString.text = lists[position].name
    }

    fun listsUpdated() {
        notifyItemInserted(lists.size-1)
    }

}
