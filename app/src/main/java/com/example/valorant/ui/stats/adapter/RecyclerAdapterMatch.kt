package com.example.valorant.ui.stats.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.valorant.model.matchList
import androidx.recyclerview.widget.RecyclerView
import com.example.valorant.R
import com.example.valorant.ui.stats.viewholder.MatchViewHolder

class RecyclerAdapterMatch(private val context: Context) : RecyclerView.Adapter<MatchViewHolder>() {
    var data = mutableListOf<matchList>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflatedView = LayoutInflater.from(context).inflate(R.layout.list_match, parent, false)
        return MatchViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(data[position])
    }

}