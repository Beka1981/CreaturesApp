package com.benten.creaturesapp.views.allCreatures.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benten.creaturesapp.databinding.LayoutCreatureItemBinding
import com.benten.creaturesapp.model.Creature

class AllCreaturesAdapter : RecyclerView.Adapter<AllCreaturesAdapter.AllCreaturesViewHolder>() {

    private val creatures = mutableListOf<Creature>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCreaturesViewHolder {
        return AllCreaturesViewHolder(
            LayoutCreatureItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AllCreaturesViewHolder, position: Int) {
        holder.bind(creatures[position])
    }

    override fun getItemCount(): Int {
        return creatures.size
    }

    fun updateAll(list: List<Creature>) {
        creatures.clear()
        creatures.addAll(list)
        notifyDataSetChanged()
    }

    inner class AllCreaturesViewHolder(private val binding: LayoutCreatureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(creature: Creature) {
            binding.avatarListItem.setImageResource(creature.drawable)
            binding.name.text = creature.name
            binding.hitPoints.text = creature.hitPoints.toString()
        }
    }
}
