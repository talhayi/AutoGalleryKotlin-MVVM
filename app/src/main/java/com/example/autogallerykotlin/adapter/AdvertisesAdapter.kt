package com.example.autogallerykotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.autogallerykotlin.data.model.Advertises
import com.example.autogallerykotlin.databinding.AdvertisesItemLayoutBinding

class AdvertisesAdapter : RecyclerView.Adapter<AdvertisesAdapter.AdvertsViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class AdvertsViewHolder(
        val binding: AdvertisesItemLayoutBinding,
        listener: onItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<Advertises>() {
        override fun areItemsTheSame(oldItem: Advertises, newItem: Advertises): Boolean {
            return oldItem.advert_id == newItem.advert_id
        }

        override fun areContentsTheSame(oldItem: Advertises, newItem: Advertises): Boolean {
            return newItem == oldItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallBack)
    var advertises: List<Advertises>
    get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertsViewHolder {
        return AdvertsViewHolder(
            AdvertisesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), mListener
        )
    }

    override fun onBindViewHolder(holder: AdvertsViewHolder, position: Int) {
        val currentAdvertises = advertises[position]

        holder.binding.apply {
            advertisesRowAdvertTitleTextView.text = currentAdvertises.advert_title
            advertisesRowAddressTextView.text = currentAdvertises.address
            advertisesRowPriceTextView.text = currentAdvertises.price
            advertisesRowImageView.load("http://yazilimgunlukleri.com/autogallerykotlin/" + currentAdvertises.image) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount(): Int {
        return advertises.size
    }
}