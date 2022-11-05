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


    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener = listener
    }


    class MyAdvertiseViewHolder(val binding: MyAdvertiseItemLayoutBinding, listener: onItemClickListener):RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    private val diffCallBack = object : DiffUtil.ItemCallback<MyAdvertise>(){

        override fun areItemsTheSame(oldItem: MyAdvertise, newItem: MyAdvertise): Boolean {
            return oldItem.advert_id == newItem.advert_id
        }

        override fun areContentsTheSame(oldItem: MyAdvertise, newItem: MyAdvertise): Boolean {
            return newItem == oldItem
        }


    }


    private val differ = AsyncListDiffer(this,diffCallBack)
    var myAdvertise: List<MyAdvertise>

    get() = differ.currentList

    set(value){
       // differ.currentList.clear()
        //differ.currentList.addAll(myAdvertise)
        differ.submitList(value)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdvertiseViewHolder {
        return MyAdvertiseViewHolder(MyAdvertiseItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false),mListener)
    }


    override fun onBindViewHolder(holder: MyAdvertiseViewHolder, position: Int) {
        val currentMyAdvertise = myAdvertise[position]

        holder.binding.apply {


            myAdvertiseRowAdvertTitleTextView.text = currentMyAdvertise.advert_title
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
    /*
    fun setData(newMyAdvertiseList: List<MyAdvertise>){

        val diffUtil = MyAdvertiseDiffUtil(oldMyAdvertiseList, newMyAdvertiseList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        oldMyAdvertiseList = newMyAdvertiseList
        diffResults.dispatchUpdatesTo(this)
    }*/
}
/*
class MyAdvertiseDiffUtil(
    private val oldList: List<MyAdvertise>,
    private val newList: List<MyAdvertise>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
         return oldList[oldItemPosition].advert_id == newList[newItemPosition].advert_id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].advert_id!=newList[newItemPosition].advert_id->{
                false
            }
            oldList[oldItemPosition].image!=newList[newItemPosition].image->{
                false
            }
            oldList[oldItemPosition].advert_title!=newList[newItemPosition].advert_title->{
                false
            }
            oldList[oldItemPosition].address!=newList[newItemPosition].address->{
                false
            }
            oldList[oldItemPosition].price!=newList[newItemPosition].price->{
                false
            }
            else-> true
        }
    }

}
*/