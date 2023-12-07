package com.example.forage.data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.forage.model.Forageable
import kotlinx.coroutines.flow.Flow

@Dao
interface ForageableDao {
    @Query("SELECT * FROM forageable")
    fun getForagebles(): Flow<List<Forageable>>

    @Query("SELECT * FROM forageable WHERE id = :id")
    fun getForageable(id: Long): Flow<Forageable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(forageable: Forageable)

    @Update
    fun update(forageable: Forageable)

    @Delete
    fun delete(forageable: Forageable)
}