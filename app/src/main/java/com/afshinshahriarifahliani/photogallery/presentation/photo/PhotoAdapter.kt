package com.afshinshahriarifahliani.photogallery.presentation.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.afshinshahriarifahliani.photogallery.R
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.databinding.ListItemBinding

import com.bumptech.glide.Glide


class PhotoAdapter( var gridField:Int=0) : RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {
    private val photoList = ArrayList<PhotoItem>()

    fun setList(photoItems: List<PhotoItem>) {
        photoList.clear()
        photoList.addAll(photoItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

   inner class MyViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photoItem: PhotoItem) {
            binding.titleTextView.text = photoItem.author
            if (gridField==0)
            binding.descriptionTextView.text ="Size: ${photoItem.height} * ${photoItem.width}"
            val posterURL = photoItem.downloadUrl
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)

            binding.imageView.contentDescription=photoItem.downloadUrl.toString()

        }

    }
}


