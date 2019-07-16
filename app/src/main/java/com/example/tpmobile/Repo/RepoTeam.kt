package com.example.tpmobile.Repo

import android.app.Application
import com.example.tpmobile.Model.Bdd
import com.example.tpmobile.Model.Dao.TeamDao
import com.example.tpmobile.Model.Entity.Team


class RepoTeam (application: Application){
    private val Team: TeamDao?
     init{
         var db= Bdd.getInstance(application)
         this.Team=db!!.TeamDao()

     }
    fun insertTeam(Team:Team){
        this.Team!!.insertTeam(Team)
    }
    fun getTeam(): List<Team> {
        return  this.Team!!.getAllteam()
    }
    fun deleteTeam(team:Team){
        this.Team!!.deleteTeam(team)
    }
/*
    private var apiService = ApiService.create()

    init {
        this.apiService = ApiService.create()
    }

    fun getAllNameTeam():ArrayList<String>{
        var TeamName:ArrayList<String> = arrayListOf()
        val TeamList:ArrayList<Team>

        TeamList= apiService.getAllNameTeam().execute().body()!!
        Log.e("kkk",TeamName.toString())


      //  var blockingqueue:BlockingQueue<ArrayList<Team>>
     //   blockingqueue = ArrayBlockingQueue(1)
        var TeamList:ArrayList<Team>
        var TeamListOut:ArrayList<Team>
        var  TeamName:ArrayList<String> = arrayListOf()


/*
        apiService.getAllNameTeam().enqueue(object : Callback<ArrayList<Team>> {

            override fun onResponse(call: Call<ArrayList<Team>>?, response: Response<ArrayList<Team>?>)  {

               TeamList = response.body()!!
               // blockingqueue.add(TeamList)
                TeamList.forEach {
                    TeamName.add(it.toString())
                }
                Log.e("TeamNameMustaphaIN",TeamName.toString())
                Afficher(TeamName)


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

    fun Afficher( teamName:ArrayList<String>){
        Log.e("FromAfficher",teamName.toString())
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
    */
}