package br.com.paulosalvatore.room.repository

import android.app.Application
import androidx.lifecycle.LiveData
import br.com.paulosalvatore.room.dao.WordDao
import br.com.paulosalvatore.room.db.WordRoomDatabase
import br.com.paulosalvatore.room.entities.Word
import org.jetbrains.anko.doAsync

class WordRepository(application: Application) {
    private val wordDao: WordDao
    val allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        wordDao = db.wordDao()
        allWords = wordDao.getAllWords()
    }

    fun insert(word: Word) {
        doAsync {
            wordDao.insert(word)
        }
    }
}
