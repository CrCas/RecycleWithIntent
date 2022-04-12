package com.example.recycleviewproject.ui.main

import android.os.Parcelable
import com.example.recycleviewproject.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val title: String,
    val detail: String,
    val imageId: Int
) : Parcelable


