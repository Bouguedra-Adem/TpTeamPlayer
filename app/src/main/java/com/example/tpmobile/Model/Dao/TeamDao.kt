package com.example.tpsqlite.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tpmobile.Model.Entity.Team


@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team: Team)

    @Delete
    fun deleteTeam(team:Team)

    @Update
    fun  updateTeam(team:Team)

    @Query("SELECT * from Team")
    fun getAllteam(): List<Team>


}