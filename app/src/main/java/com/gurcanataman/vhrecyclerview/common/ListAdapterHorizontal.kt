package com.gurcanataman.vhrecyclerview.common


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gurcanataman.vhrecyclerview.databinding.RvItemHorizontalBinding
import com.gurcanataman.vhrecyclerview.databinding.RvItemVerticalBinding
import com.gurcanataman.vhrecyclerview.model.HorizontalItem
import com.gurcanataman.vhrecyclerview.model.VerticalItem

class ListAdapterHorizontal(private val listener: ItemSelectedListener) : ListAdapter<HorizontalItem, ListAdapterHorizontal.ViewHolder>(DIFF_CALLBACK) {

    interface ItemSelectedListener{
        fun onItemSelected(item : HorizontalItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(getItem(position))
        holder.binding.listener = listener
    }

    class ViewHolder(val binding: RvItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
                val itemCurriculumClassesBinding = RvItemHorizontalBinding.inflate(inflater, parent, false)
                return ViewHolder(itemCurriculumClassesBinding)
            }
        }

        fun bind(item: HorizontalItem){
            binding.item = item
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HorizontalItem>() {
            override fun areItemsTheSame(oldItem: HorizontalItem, newItem: HorizontalItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: HorizontalItem, newItem: HorizontalItem): Boolean =
                oldItem == newItem

        }
    }


}