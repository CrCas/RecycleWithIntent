package com.example.recycleviewproject.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recycleviewproject.R
import java.util.*

class MainViewModel : ViewModel() {
    private val _data: MutableLiveData<List<Data>> = MutableLiveData()
    val data: LiveData<List<Data>>
        get() = _data;

    init {
        initData()
    }

    private fun initData() {
        val list = mutableListOf(
            Data("Chapter One", "Item one details", R.drawable.android_image_1),
            Data("Chapter Two", "Item two details", R.drawable.android_image_2),
            Data("Chapter Three", "Item three details", R.drawable.android_image_3),
            Data("Chapter Four", "Item four details", R.drawable.android_image_4),
            Data("Chapter Five", "Item five details", R.drawable.android_image_5),
            Data("Chapter Six", "Item six details", R.drawable.android_image_6),
            Data("Chapter Seven", "Item seven details", R.drawable.android_image_7),
            Data("Chapter Eight", "Item eight details", R.drawable.android_image_8),
        )
        list.shuffle()
        _data.value = list
    }
}

