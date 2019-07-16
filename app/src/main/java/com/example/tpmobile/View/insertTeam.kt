package com.example.tpmobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Entity.Team
import com.example.tpmobile.R
import com.example.tpmobile.Repo.RepoTeam
import com.example.tpmobile.Repo.ServiceWorker
import kotlinx.android.synthetic.main.activity_insert_team.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class insertTeam : AppCompatActivity() {
    var repoTeam: RepoTeam? = null
   private var apiService = ApiService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_team)
         button4.setOnClickListener {
              this.repoTeam= RepoTeam(application)
              var team: Team = Team ("1",filed1.text.toString(),fILED2.toString())
               this.repoTeam!!.insertTeam(team)
             val contraints = Constraints.Builder().
                 setRequiredNetworkType(NetworkType.UNMETERED).
                 setRequiresBatteryNotLow(true). setRequiresCharging(true).
                 setRequiresStorageNotLow(true). build()
             val req = OneTimeWorkRequest. Builder (ServiceWorker::class.java)
                 .setConstraints(contraints). build()
             /*
              apiService.createTeam(team).enqueue(object : Callback<Team>{

                 override fun onResponse(call: Call<Team>?, response: Response<Team>?)  {

                     Toast.makeText(applicationContext, "insertion avec succée ",  Toast.LENGTH_SHORT).show()
                 }

                 override fun onFailure(call: Call<Team>, t: Throwable) {
                     Toast.makeText(applicationContext, "erreur ",  Toast.LENGTH_SHORT).show()
                     error("KO")

                 }
             })*/


         }
    }
}
