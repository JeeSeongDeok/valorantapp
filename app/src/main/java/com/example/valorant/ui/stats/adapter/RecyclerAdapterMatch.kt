package com.example.valorant.ui.stats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.valorant.model.matchList
import androidx.recyclerview.widget.RecyclerView
import com.example.valorant.R
import com.example.valorant.ui.stats.viewholder.MatchViewHolder

class RecyclerAdapterMatch(private val items: matchList) : RecyclerView.Adapter<MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.list_match, parent, false)
        return MatchViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {

    }

}