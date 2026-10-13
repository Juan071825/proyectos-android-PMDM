package com.example.affirmations.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @DrawableRes var imageRes : Int,
    @StringRes var textRes : Int
)
