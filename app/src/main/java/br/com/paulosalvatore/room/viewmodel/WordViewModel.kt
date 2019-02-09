package br.com.paulosalvatore.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.paulosalvatore.room.entities.Word
import br.com.paulosalvatore.room.repository.WordRepository

class WordViewModel(application: Application) :
    AndroidViewModel(application) {
    private val repository = WordRepository(application)

    val allWords = repository.allWords

    fun insert(word: Word) {
        repository.insert(word)
    }
}
