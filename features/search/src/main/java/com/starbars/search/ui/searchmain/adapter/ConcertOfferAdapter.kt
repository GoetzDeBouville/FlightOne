package com.starbars.search.ui.searchmain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.starbars.search.databinding.ItemFlightOfferBinding
import com.starbars.search.domain.model.ConcertOffer
import com.starbars.search.ui.adapter.DiffCallback

internal class ConcertOfferAdapter :
    ListAdapter<ConcertOffer, ConcertOfferAdapter.ConcertOfferViewHolder>(
        DiffCallback<ConcertOffer>()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcertOfferViewHolder {
        val binding = ItemFlightOfferBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ConcertOfferViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConcertOfferViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ConcertOfferViewHolder(private val binding: ItemFlightOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: ConcertOffer) = with(binding) {
            tvOfferCity.text = offer.city
            tvOfferPrice.text = offer.price + " ₽"
            tvOfferTitle.text = offer.title
            ivOfferImg.load(offer.imageResId) {
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