package com.example.tpmobile.Model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity (tableName ="Team")
data class Team (@PrimaryKey @NotNull var _id:String,
                 @NotNull var  team_name:String,
                 @NotNull var continent :String){
}

