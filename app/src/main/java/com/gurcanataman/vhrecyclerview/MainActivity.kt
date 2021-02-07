package com.gurcanataman.vhrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.gurcanataman.vhrecyclerview.common.HorizontalContainerAdapter
import com.gurcanataman.vhrecyclerview.common.ListAdapterHorizontal
import com.gurcanataman.vhrecyclerview.common.ListAdapterVertical
import com.gurcanataman.vhrecyclerview.databinding.ActivityMainBinding
import com.gurcanataman.vhrecyclerview.model.HorizontalItem
import com.gurcanataman.vhrecyclerview.model.VerticalItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()
    }

    private fun initUI() {
        val horizontalAdapter = setHorizontalAdapter()
        val verticalAdapter = setVerticalAdapter()
        horizontalAdapter.submitList(getHorizontalItemList())
        verticalAdapter.submitList(getVerticalItemList())

        val horizontalContainerAdapter = HorizontalContainerAdapter(horizontalAdapter)

        val concatAdapter = ConcatAdapter(horizontalContainerAdapter,verticalAdapter)


        binding.rvItems.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = concatAdapter

        }
    }

    private fun setHorizontalAdapter() =
        ListAdapterHorizontal(object : ListAdapterHorizontal.ItemSelectedListener {
            override fun onItemSelected(item: HorizontalItem) {

            }

        })

    private fun setVerticalAdapter() =
        ListAdapterVertical(object : ListAdapterVertical.ItemSelectedListener {
            override fun onItemSelected(item: VerticalItem) {

            }


        })

    private fun getHorizontalItemList() : ArrayList<HorizontalItem>{

        val list =  arrayListOf<HorizontalItem>()
        for (i in 1..10){
            list.add(HorizontalItem(i.toLong(),"H_Title$i"))

        }
        return list

    }

    private fun getVerticalItemList() : ArrayList<VerticalItem>{
        val list =  arrayListOf<VerticalItem>()
        for (i in 1..20){
            list.add(VerticalItem(i.toLong(),"V_Title$i"))

        }
        return list
    }
}