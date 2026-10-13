package com.example.cuadricula.models

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(

    @StringRes var nameRes : Int,
    var number : Int,
    @DrawableRes var imageRes : Int
)
