package br.com.paulosalvatore.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.paulosalvatore.room.entities.Word

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER by word ASC")
    fun getAllWords(): LiveData<List<Word>>
}
