package com.example.myapplication.presentation.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.myapplication.R
@BindingAdapter("AbsoluteMagnitudeTextView")
fun bindTextToAbsoluteMagnitude(textView: TextView, number: Double) {
    val textContext = textView.context
    textView.text = String.format(
        textContext.getString(R.string.astronomical_unit_format_text_and_add_the_new_text),
        number
    )
}

@BindingAdapter("EstimatedDiameterMaxTextView")
fun bindTextToEstimatedDiameterMax(textView: TextView, number: Double) {
    val textContext = textView.context
    textView.text = String.format(
        textContext.getString(R.string.estimated_diameter_text),
        number
    )
}

@BindingAdapter("kilometersPerSecondTextView")
fun bindTextToKilometersPerSecond(textView: TextView, number: String) {
    val textContext = textView.context
    textView.text = String.format(
        textContext.getString(R.string.kilometers_per_second_text_view),
        number.toDouble()
    )
}

@BindingAdapter("astronomicalTextView")
fun bindTextToAstronomical(textView: TextView, number: String) {
    val textContext = textView.context
    textView.text = String.format(
        textContext.getString(R.string.astronomical_text_view),
        number.toDouble()
    )
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImageView(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

