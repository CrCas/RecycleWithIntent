package com.example.recycleviewproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewproject.R
import com.example.recycleviewproject.databinding.CardLayoutBinding
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(
    private val dataList: List<Data>,
    private val onClickListener: (data: Data, position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(
) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding =
            CardLayoutBinding.inflate(LayoutInflater.from(viewGroup.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        val data = dataList[i]
        holder.binding.itemTitle.text = data.title
        holder.binding.itemTitle.text = data.title
        holder.binding.itemDetail.text = data.detail
        holder.binding.itemImage.setImageResource(data.imageId)

        holder.binding.root.setOnClickListener {
            onClickListener(data, i)
        }
    }


    inner class ViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)


}