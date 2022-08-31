package com.benten.creaturesapp.views.avatars.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benten.creaturesapp.databinding.FragmentChooseAvatarBinding
import com.benten.creaturesapp.databinding.LayoutAvatarChooserItemBinding

class AvatarChoserAdapter : RecyclerView.Adapter<AvatarChoserAdapter.AvatarChoserViewHolder>() {

    private val avatarList = mutableListOf<Int>()
    private var onClickListener: ((Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarChoserViewHolder {
        return AvatarChoserViewHolder(
            LayoutAvatarChooserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AvatarChoserViewHolder, position: Int) {
        holder.bindData(avatarList[position])
    }

    override fun getItemCount(): Int {
        return avatarList.size
    }

     fun setOnAvatarChosenListener(listener: ((Int) -> Unit)) {
        this.onClickListener = listener
    }

    fun updateAll(list: List<Int>) {
        avatarList.clear()
        avatarList.addAll(list)
        notifyDataSetChanged()
    }

    inner class AvatarChoserViewHolder(val binding: LayoutAvatarChooserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(drawableRes: Int) {
            binding.ivAvatar.setImageResource(drawableRes)
            binding.ivAvatar.setOnClickListener {
                onClickListener?.invoke(drawableRes)
            }
        }
    }
}