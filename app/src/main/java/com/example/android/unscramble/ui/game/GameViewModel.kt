package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel(){
    init {
        Log.d("GameViewModel", "GameViewModel Create!")
    }

    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "text"

    private var _count = 0
    val count: Int
    get() = _count

    val currentScrambledWord: String
    get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("GameViewModel", "GameViewModel Created")
    }
}