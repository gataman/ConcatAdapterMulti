package com.gurcanataman.vhrecyclerview.common


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gurcanataman.vhrecyclerview.databinding.RvItemVerticalBinding
import com.gurcanataman.vhrecyclerview.model.VerticalItem

class ListAdapterVertical(private val listener: ItemSelectedListener) : ListAdapter<VerticalItem, ListAdapterVertical.ViewHolder>(DIFF_CALLBACK) {

    interface ItemSelectedListener{
        fun onItemSelected(item : VerticalItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(getItem(position))
        holder.binding.listener = listener
    }

    class ViewHolder(val binding: RvItemVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
                val itemCurriculumClassesBinding = RvItemVerticalBinding.inflate(inflater, parent, false)
                return ViewHolder(itemCurriculumClassesBinding)
            }
        }

        fun bind(item: VerticalItem){
            binding.item = item
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<VerticalItem>() {
            override fun areItemsTheSame(oldItem: VerticalItem, newItem: VerticalItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: VerticalItem, newItem: VerticalItem): Boolean =
                oldItem == newItem

        }
    }


}