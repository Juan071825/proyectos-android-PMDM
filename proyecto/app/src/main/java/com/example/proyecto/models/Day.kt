package com.example.proyecto.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @DrawableRes val imageRes : Int,
    @StringRes val textRes : Int,
    @StringRes val numberRes : Int
);
