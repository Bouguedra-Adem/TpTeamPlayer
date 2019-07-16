package com.example.tpmobile.Repo

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.work.ListenableWorker.Result.*
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Entity.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceWorker(val ctx:Context ,val param:WorkerParameters):Worker(ctx,param) {
var repoTeam: RepoTeam? = null
    private var apiService = ApiService.create()
    override fun doWork(): Result {
        this.repoTeam= RepoTeam(this.ctx as Application)
        this.repoTeam!!.getTeam().forEach(this::AddTeam)
        this.repoTeam!!.getTeam().forEach {
            this.repoTeam!!.deleteTeam(it)
        }
        return success()
    }

    fun AddTeam(team: Team){
        apiService.createTeam(team).enqueue(object : Callback<Team> {

            override fun onResponse(call: Call<Team>?, response: Response<Team>?)  {

                Toast.makeText(applicationContext, "insertion avec succée ",  Toast.LENGTH_SHORT).show()
                success()
            }

            override fun onFailure(call: Call<Team>, t: Throwable) {
                Toast.makeText(applicationContext, "erreur ",  Toast.LENGTH_SHORT).show()
                error("KO")

            }
        })

    }
}