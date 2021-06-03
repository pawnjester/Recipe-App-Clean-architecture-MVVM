package com.example.presentation.mvi

import kotlinx.coroutines.flow.Flow

interface MVIView<out I: ViewIntent, in S: ViewState> {
    fun render(state: S)
    val intents : Flow<I>
}