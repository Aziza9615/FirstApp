package com.example.firstapp.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firstapp.model.Publication

interface InstagramDao {
    @Insert(onConflict = OnConflictStrategy. IGNORE)
    fun InsertPublications(data: List<Publication>?)

    @Query("SELECT * FROM publications")
    fun getPublications(): List<Publication>
}