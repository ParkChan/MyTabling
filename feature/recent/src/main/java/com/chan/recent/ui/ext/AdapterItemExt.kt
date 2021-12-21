package com.chan.recent.ui.ext

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chan.recent.R

import com.chan.recent.domain.Product

@BindingAdapter("setGlideThumb")
fun bindingGlideThumb(imageView: ImageView, uri: String?) {
    Glide.with(imageView)
        .load(uri)
        .error(R.drawable.ic_bg_error)
        .fallback(R.drawable.ic_bg_error)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
        .into(imageView)
}

@BindingAdapter("setRatingAndReviewCnt")
fun bindingRatingAndReviewCnt(textView: TextView, product: Product) {
    textView.text = String.format(
        textView.resources.getString(R.string.rating_review),
        product.rating,
        product.reviewCount
    )
}

@BindingAdapter("setUseBooking")
fun bindingIsBooking(textView: TextView, product: Product) {
    if (product.useBooking) {
        if (product.isQuickBooking) {
            textView.text = textView.resources.getText(R.string.booking)
            textView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.GONE
        }
    } else {
        textView.visibility = View.GONE
    }
}

@BindingAdapter("setRemoteWaiting")
fun bindingIsRemoteWaiting(textView: TextView, product: Product) {
    if (product.useWaiting) {
        if (product.isRemoteWaiting) {
            textView.text = textView.resources.getText(R.string.remote_waiting)
            textView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.GONE
        }
    } else {
        textView.visibility = View.GONE
    }
}