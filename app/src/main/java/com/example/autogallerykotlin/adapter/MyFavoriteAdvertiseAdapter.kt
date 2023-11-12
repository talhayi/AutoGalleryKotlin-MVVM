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

    private lateinit var mListener: OnItemClickListener
    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener = listener
    }
    class MyFavoriteAdvertiseViewHolder(val binding: MyFavoriteAdvertiseItemLayoutBinding, listener: OnItemClickListener):RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<MyFavoriteAdvertise>(){

        override fun areItemsTheSame(oldItem: MyFavoriteAdvertise, newItem: MyFavoriteAdvertise): Boolean {
            return oldItem.advertId == newItem.advertId
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
            myFavoriteAdvertiseRowAdvertTitleTextView.text = currentMyFavoriteAdvertise.advertTitle
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
