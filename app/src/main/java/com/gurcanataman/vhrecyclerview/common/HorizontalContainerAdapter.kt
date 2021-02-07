package com.gurcanataman.vhrecyclerview.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gurcanataman.vhrecyclerview.databinding.RvItemHorizontalContainerBinding


class HorizontalContainerAdapter(
    private val adapter: ListAdapterHorizontal
) : RecyclerView.Adapter<HorizontalContainerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun getItemCount(): Int = 1

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(adapter)

    }


    class MyViewHolder(private val binding: RvItemHorizontalContainerBinding, private val ctx: Context) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): MyViewHolder {
                val itemBinding = RvItemHorizontalContainerBinding.inflate(inflater, parent, false)
                return MyViewHolder(itemBinding, parent.context)
            }
        }

        fun bind(adapter: ListAdapterHorizontal) {

            binding.rvHorizontalContainer.apply {
                this.adapter = adapter
                this.layoutManager = LinearLayoutManager(ctx,LinearLayoutManager.HORIZONTAL,false)
            }
            binding.executePendingBindings()

        }


    }


}