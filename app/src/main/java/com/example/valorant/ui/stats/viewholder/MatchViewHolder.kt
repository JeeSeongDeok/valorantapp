package com.example.valorant.ui.stats.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valorant.R
import com.example.valorant.model.matchList
import com.example.valorant.utils.ChangerankUtil

class MatchViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private  var view : View = v
    private val rankIcon:ImageView = itemView.findViewById(R.id.list_match_rankIcon)
    private val matchDate:TextView = itemView.findViewById(R.id.list_match_date)
    private val matchElo:TextView = itemView.findViewById(R.id.list_match_rankInfo)
    private val mmr:TextView = itemView.findViewById(R.id.list_match_mmrInfo)
    fun bind(item:matchList){
        Glide.with(view)
                .load(ChangerankUtil.getRankIcon(item.currenttier!!))
                .into(rankIcon)
        matchDate.text = item.date
        matchElo.text = item.elo.toString()
        mmr.text = item.ranking_in_tier.toString()
    }
}