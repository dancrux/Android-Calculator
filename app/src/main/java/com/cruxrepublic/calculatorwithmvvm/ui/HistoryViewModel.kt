package com.cruxrepublic.calculatorwithmvvm.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class HistoryViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // TODO: Implement the ViewModel
    val calculation: String = savedStateHandle["uid"] ?: throw
            kotlin.IllegalArgumentException("missing user id")
}
