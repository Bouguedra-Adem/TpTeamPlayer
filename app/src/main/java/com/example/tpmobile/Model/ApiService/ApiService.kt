package com.example.tpmobile.Model.ApiService

import com.example.tpmobile.Model.Player
import com.example.tpmobile.Model.Team
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {


    @GET("/Team")
    fun getAllNameTeam():Call<ArrayList<Team>>


    @GET("/Player/{team_name}")
    fun getAllPlayeByNameTeam(@Path(value = "team_name", encoded = true) team_name: String):Call<ArrayList<Player>>

    @POST("/CreateTeam")
    fun createTeam(@Body team:Team):Call<Team>

    //https://radiant-brook-13048.herokuapp.com/
    //http://10.0.2.2:3000/

    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://radiant-brook-13048.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}