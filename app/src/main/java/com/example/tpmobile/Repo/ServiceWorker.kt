package com.example.tpmobile.Repo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.work.ListenableWorker
import androidx.work.ListenableWorker.Result.*
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Entity.Team
import com.google.common.util.concurrent.ListenableFuture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.ResultSet

class ServiceWorker(val ctx:Context ,val param:WorkerParameters):ListenableWorker(ctx,param) {
    var repoTeam: RepoTeam? = null
    private var apiService = ApiService.create()
   @SuppressLint("RestrictedApi")
   override fun startWork(): ListenableFuture<Result>{
      /*  this.repoTeam= RepoTeam(this.ctx as Application)
        this.repoTeam!!.getTeam().forEach(this::AddTeam)
        this.repoTeam!!.getTeam().forEach {
            this.repoTeam!!.deleteTeam(it)
        }
        return success()*/
       val future = SettableFuture.create<Result>()
       this.repoTeam= RepoTeam(this.ctx as Application)

       val listteam: List<Team> = this.repoTeam!!.getTeam()
       val team = listteam!!.get(0)




       apiService.createTeam(team).enqueue(object : Callback<Team> {

           override fun onResponse(call: Call<Team>?, response: Response<Team>?) {

               Toast.makeText(applicationContext, "insertion avec succée ", Toast.LENGTH_SHORT).show()
               if (response!!.isSuccessful)
                   future.set(Result.success())
               else
                   future.set(Result.retry())
           }

           override fun onFailure(call: Call<Team>, t: Throwable) {
               Toast.makeText(applicationContext, "erreur ", Toast.LENGTH_SHORT).show()
               future.set(Result.retry())
               error("KO")

           }
       })

        return future
    }

    /*fun AddTeam(team: Team){
        apiService.createTeam(team).enqueue(object : Callback<Team> {

            override fun onResponse(call: Call<Team>?, response: Response<Team>?)  {

                Toast.makeText(applicationContext, "insertion avec succée ",  Toast.LENGTH_SHORT).show()
                success()
            }

            override fun onFailure(call: Call<Team>, t: Throwable) {
                Toast.makeText(applicationContext, "erreur ",  Toast.LENGTH_SHORT).show()
                error("KO")

            }
        })*/

    }
