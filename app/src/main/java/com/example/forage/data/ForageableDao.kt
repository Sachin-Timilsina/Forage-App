package com.example.forage.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.forage.model.Forageable
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for database interaction.
 */
@Dao
interface ForageableDao {

    // implement a method to retrieve all Forageables from the database
    @Query("SELECT * FROM FORAGEABLE_DATABASE")
    fun getForageables(): Flow<List<Forageable>>

    //  implement a method to retrieve a Forageable from the database by id
    @Query("SELECT * FROM FORAGEABLE_DATABASE WHERE id = :id")
    fun getForageable(id: Long) : Flow<Forageable>

    // implement a method to insert a Forageable into the database
    //  (use OnConflictStrategy.REPLACE)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forageable: Forageable)

    // implement a method to update a Forageable that is already in the database
    @Update
    suspend fun update(forageable: Forageable)

    // implement a method to delete a Forageable from the database.
    @Delete
    suspend fun delete(forageable: Forageable)
}
