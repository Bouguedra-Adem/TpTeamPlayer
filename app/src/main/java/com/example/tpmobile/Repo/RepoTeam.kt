package com.example.tpmobile.Repo

import android.os.Build
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Player
import com.example.tpmobile.Model.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.math.log

class RepoTeam {

    private var apiService = ApiService.create()

    init {
        this.apiService = ApiService.create()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getAllNameTeam():ArrayList<String>{
        var TeamName:ArrayList<String> = arrayListOf()
        val TeamList:ArrayList<Team>

        TeamList= apiService.getAllNameTeam().execute().body()!!
        Log.e("kkk",TeamName.toString())


/*
        apiService.getAllNameTeam().enqueue(object : Callback<ArrayList<Team>> {

            override fun onResponse(call: Call<ArrayList<Team>>?, response: Response<ArrayList<Team>?>)  {

               TeamList = response.body()!!

                  TeamList.forEach {
                      Log.e("team",it.toString())
                    TeamName.add(it.team_name)

                          }

                Log.e("teamname1",TeamName.toString())


            }
            override fun onFailure(call: Call<ArrayList<Team>>, t: Throwable) {
                Log.e("tag",t.message)
                Log.e("tag",t.cause.toString())

                error("KO")

            }

        })*/


      return  TeamName

    }
    fun getListPlayerByNameTeam(NameTeam:String):ArrayList<Player>{
        var PlayerList:ArrayList<Player> = arrayListOf()
        apiService.getAllPlayeByNameTeam(NameTeam).enqueue(object : Callback<ArrayList<Player>> {
            override fun onResponse(call: Call<ArrayList<Player>>, response: Response<ArrayList<Player>>) {
                PlayerList = response.body()!!
                if (PlayerList != null) {
                    Log.d("Allname","Allaname")
                }
            }
            override fun onFailure(call: Call<ArrayList<Player>>, t: Throwable) {
                error("KO")
            }
        })


        return PlayerList

    }

    fun CreateTeam(team:Team):String{
        var stringReponse:String=""
        apiService.createTeam(team).enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>, response: Response<Team>) {
               stringReponse="inserstion team avec succee"
            }
            override fun onFailure(call: Call<Team>, t: Throwable) {
                error("KO")
                stringReponse="erreur lors de l'inserstion "
            }
        })
        return  stringReponse
    }
}