package com.starbars.search.ui.searchdialog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.starbars.search.databinding.ItemFamousRouteBinding
import com.starbars.search.domain.model.PlaceOffer
import com.starbars.search.ui.adapter.DiffCallback

internal class FamousRouteAdapter(
    private val onPlaceClickListener: (String) -> Unit
) : ListAdapter<PlaceOffer, FamousRouteAdapter.FamousRouteViewHolder>(DiffCallback<PlaceOffer>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamousRouteViewHolder {
        val binding = ItemFamousRouteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FamousRouteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FamousRouteViewHolder, position: Int) {
        val placeOffer = currentList[position]
        holder.bind(placeOffer)
        holder.itemView.setOnClickListener {
            onPlaceClickListener.invoke(placeOffer.city)
        }
    }

    class FamousRouteViewHolder(private val binding: ItemFamousRouteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(placeOffer: PlaceOffer) = with(binding) {
            tvCity.text = placeOffer.city
            tvDescription.text = placeOffer.description
            ivPlace.load(placeOffer.imageResId) {
                error(com.starbars.uikit.R.drawable.ic_error_placeholder_48)
                    .scale(coil.size.Scale.FIT)
                placeholder(com.starbars.uikit.R.drawable.ic_download_placeholder_48)
                    .scale(coil.size.Scale.FIT)

                transformations(
                    RoundedCornersTransformation()
                ).crossfade(true)
            }
        }
    }
}