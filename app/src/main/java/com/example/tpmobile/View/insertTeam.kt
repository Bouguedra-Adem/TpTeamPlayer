package com.example.tpmobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Team
import com.example.tpmobile.R
import kotlinx.android.synthetic.main.activity_insert_team.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class insertTeam : AppCompatActivity() {

   private var apiService = ApiService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_team)
         button4.setOnClickListener {
              var team: Team =Team ("adem",filed1.text.toString(),fILED2.toString())
              apiService.createTeam(team).enqueue(object : Callback<Team>{

                 override fun onResponse(call: Call<Team>?, response: Response<Team>?)  {

                     Toast.makeText(applicationContext, "insertion avec succée ",  Toast.LENGTH_SHORT).show()
                 }

                 override fun onFailure(call: Call<Team>, t: Throwable) {
                     Toast.makeText(applicationContext, "erreur ",  Toast.LENGTH_SHORT).show()
                     error("KO")

                 }
             })


         }
    }
}
