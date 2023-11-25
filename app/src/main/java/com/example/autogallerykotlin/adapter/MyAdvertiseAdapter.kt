package com.example.autogallerykotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.autogallerykotlin.data.model.MyAdvertise
import com.example.autogallerykotlin.databinding.MyAdvertiseItemLayoutBinding

class MyAdvertiseAdapter : RecyclerView.Adapter<MyAdvertiseAdapter.MyAdvertiseViewHolder>() {
    private lateinit var mListener: OnItemClickListener
    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener = listener
    }
    class MyAdvertiseViewHolder(val binding: MyAdvertiseItemLayoutBinding, listener: OnItemClickListener):
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<MyAdvertise>(){
        override fun areItemsTheSame(oldItem: MyAdvertise, newItem: MyAdvertise): Boolean {
            return oldItem.advertId == newItem.advertId
        }

        override fun areContentsTheSame(oldItem: MyAdvertise, newItem: MyAdvertise): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this,diffCallBack)
    var myAdvertise: List<MyAdvertise>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdvertiseViewHolder {
        return MyAdvertiseViewHolder(
            MyAdvertiseItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false),mListener)
    }

    override fun onBindViewHolder(holder: MyAdvertiseViewHolder, position: Int) {
        val currentMyAdvertise = myAdvertise[position]
        holder.binding.apply {
            myAdvertiseRowAdvertTitleTextView.text = currentMyAdvertise.advertTitle
            myAdvertiseRowAddressTextView.text = currentMyAdvertise.address
            myAdvertiseRowPriceTextView.text = currentMyAdvertise.price
            myAdvertiseRowImageView.load("http://yazilimgunlukleri.com/autogallerykotlin/"+currentMyAdvertise.image){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount(): Int {
        return myAdvertise.size
    }
}