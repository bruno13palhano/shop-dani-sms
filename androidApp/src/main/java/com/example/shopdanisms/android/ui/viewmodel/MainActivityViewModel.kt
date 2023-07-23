package com.example.shopdanisms.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopdanisms.SmsSDK
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.stateIn

class MainActivityViewModel(
    sdk: SmsSDK
) : ViewModel() {
    val products = sdk.getAll()
        .stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(5_000),
            initialValue = listOf()
        )
}