package com.example.android3_hw8

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3_hw8.databinding.ItemCharacterBinding

class CharactersListAdapter(private val charactersList: List<Character>, val onClick: (character : Character) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(charactersList[position], holder.itemView.context)
        holder.itemView.setOnClickListener(){
            onClick(charactersList[position])
        }
    }


    override fun getItemCount(): Int {
        return charactersList.size
    }
}

class ViewHolder(val binding: ItemCharacterBinding, onClick: (character: Character) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(character: Character, context: Context) {
        binding.tvCharacterName.text = character.name
        binding.tvCharacterStatus.text = character.status
        Glide.with(context)
            .load(character.image)
            .into(binding.ivCharacter)
    }
}
