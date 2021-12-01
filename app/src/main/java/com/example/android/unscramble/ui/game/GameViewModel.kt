package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.example.android.unscramble.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GameViewModel: ViewModel() {
    init {
        Log.d("GameFragment", "GameViewModel Created")
        getNextWord()
    }

    init {
        Log.d("GameViewModel", "GameViewModel Create!")
    }

    private var _score = 0
    val score: Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord


    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    override fun onCleared() {
        super.onCleared()
        Log.d("GameViewModel", "GameViewModel Created")
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        var tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }

        if (wordList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

//    private fun showFinalScoreDialog() {
//        MaterialAlertDialogBuilder(requireContext())
//            .setTitle(getString.congratulations)
//    }
}