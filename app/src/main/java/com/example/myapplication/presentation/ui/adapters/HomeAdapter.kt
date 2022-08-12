package com.example.myapplication.presentation.ui.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemAsteroidBinding
import com.example.myapplication.domain.model.DataModel

class HomeAdapter(
    private var data: MutableList<DataModel>,
    private val itemClick: OnItemClickListener
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private lateinit var binding: ItemAsteroidBinding

    fun setList(data: MutableList<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(binding: ItemAsteroidBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClick.onClick(data[adapterPosition])
            }
        }

        fun bind(data: DataModel) = with(binding) {
            tvTitle.text = data.name
            tvDate.text = data.date
            if (data.isPotentiallyHazardousAsteroid) {
                ivEmoji.setImageResource(R.drawable.ic_status_potentially_hazardous)
            } else {
                ivEmoji.setImageResource(R.drawable.ic_status_normal)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate<ItemAsteroidBinding>(
                inflater,
                R.layout.item_asteroid,
                parent,
                false
            )
        return HomeViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(data[position])


    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickListener {
        fun onClick(item: DataModel)
    }
}