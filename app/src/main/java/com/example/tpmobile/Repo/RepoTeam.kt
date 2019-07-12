package com.example.tpmobile.Repo

import android.util.Log
import android.widget.Toast
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Player
import com.example.tpmobile.Model.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class RepoTeam {
    private var apiService = ApiService.create()

    init {
        this.apiService = ApiService.create()
    }

    fun getAllNameTeam(NameTeam:String):ArrayList<String>{

        var NameList:ArrayList<String> = arrayListOf()
        apiService.getAllNameTeam(NameTeam).enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                NameList = response.body()!!
                if (NameList != null) {
                  Log.d("Allname","Allaname")
                }
            }
            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                error("KO")
            }
        })


        return NameList
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
        apiService.createAccount(team).enqueue(object : Callback<Team> {
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