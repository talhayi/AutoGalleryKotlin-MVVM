package com.example.autogallerykotlin.adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.autogallerykotlin.data.model.MyFavoriteAdvertise
import com.example.autogallerykotlin.databinding.MyFavoriteAdvertiseItemLayoutBinding



class MyFavoriteAdvertiseAdapter : RecyclerView.Adapter<MyFavoriteAdvertiseAdapter.MyFavoriteAdvertiseViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener = listener
    }


    class MyFavoriteAdvertiseViewHolder(val binding: MyFavoriteAdvertiseItemLayoutBinding, listener: onItemClickListener):RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    private val diffCallBack = object : DiffUtil.ItemCallback<MyFavoriteAdvertise>(){

        override fun areItemsTheSame(oldItem: MyFavoriteAdvertise, newItem: MyFavoriteAdvertise): Boolean {
            return oldItem.advert_id == newItem.advert_id
        }

        override fun areContentsTheSame(oldItem: MyFavoriteAdvertise, newItem: MyFavoriteAdvertise): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallBack)
    var myFavoriteAdvertise: List<MyFavoriteAdvertise>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }

  //  var onItemClick: ((MyAdvertise)-> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavoriteAdvertiseViewHolder {
        return MyFavoriteAdvertiseViewHolder(MyFavoriteAdvertiseItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false),mListener)
    }


    override fun onBindViewHolder(holder: MyFavoriteAdvertiseViewHolder, position: Int) {
        val currentMyFavoriteAdvertise = myFavoriteAdvertise[position]

        holder.binding.apply {


            myFavoriteAdvertiseRowAdvertTitleTextView.text = currentMyFavoriteAdvertise.advert_title
            myFavoriteAdvertiseRowAddressTextView.text = currentMyFavoriteAdvertise.address
            myFavoriteAdvertiseRowPriceTextView.text = currentMyFavoriteAdvertise.price
            myFavoriteAdvertiseRowImageView.load("http://yazilimgunlukleri.com/autogallerykotlin/"+currentMyFavoriteAdvertise.image){
                crossfade(true)
                crossfade(1000)
            }

        }


        /*
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentMyAdvertise)
        }*/


    }

    override fun getItemCount(): Int {
       return myFavoriteAdvertise.size
    }
}
