package com.plads.testglide.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.plads.testglide.R
import com.plads.testglide.data.model.ImageModel
import kotlinx.android.synthetic.main.row_image.view.*
import kotlin.properties.Delegates
import kotlin.time.ExperimentalTime
import kotlin.time.MonoClock

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    var renderables: List<ImageModel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.row_image, parent, false)

        return ImageViewHolder(root)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = renderables.get(position)
        image.let {
            (holder).bind(it)
        }
    }

    override fun getItemCount(): Int = renderables.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @UseExperimental(ExperimentalTime::class)
        fun bind(model: ImageModel) {
            val mark = MonoClock.markNow()
            Glide.with(itemView)
                .asBitmap()
                .load(model.imageUrl)
                .placeholder(R.drawable.rose)
                .transition(BitmapTransitionOptions.withCrossFade(1000))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(itemView.image)
                .let {
                    Log.d("Timee", "Elapsed time: ${model.id} - " +
                            mark.elapsedNow().toString() +
                            "\n(Size in Bytes: ${model.size})")
                }
        }
    }
}