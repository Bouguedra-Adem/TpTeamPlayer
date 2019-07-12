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


    @GET("/team/{team_name}")
    fun getAllNameTeam(@Path(value = "team_name", encoded = true) team_name: String):Call<ArrayList<String>>


    @GET("/Player/{team_name}")
    fun getAllPlayeByNameTeam(@Path(value = "team_name", encoded = true) team_name: String):Call<ArrayList<Player>>

    @POST("/CreateTeam")
    fun createAccount(@Body team:Team):Call<Team>


    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://ancient-harbor-80131.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}