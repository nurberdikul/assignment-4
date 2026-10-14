package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val artistRes: Int,
    @StringRes val descriptionRes: Int
)

val artworks = listOf(
    Artwork(
        imageRes = R.drawable.artwork_sunset,
        titleRes = R.string.sunset_title,
        artistRes = R.string.sunset_artist,
        descriptionRes = R.string.sunset_description
    ),
    Artwork(
        imageRes = R.drawable.artwork_mountains,
        titleRes = R.string.mountains_title,
        artistRes = R.string.mountains_artist,
        descriptionRes = R.string.mountains_description
    ),
    Artwork(
        imageRes = R.drawable.artwork_city,
        titleRes = R.string.city_title,
        artistRes = R.string.city_artist,
        descriptionRes = R.string.city_description
    )
)