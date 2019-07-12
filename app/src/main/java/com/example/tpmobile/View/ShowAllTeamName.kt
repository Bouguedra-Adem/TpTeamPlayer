package com.example.tpmobile.View

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Team
import com.example.tpmobile.R
import com.example.tpmobile.ViewModel.ViewModelTeam
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowAllTeamName : AppCompatActivity() {
    private var apiService = ApiService.create()

    private lateinit var listView : ListView
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_team_name)
        //val viewModel= ViewModelProviders.of(this).get(ViewModelTeam ::class.java)

// 1
       // var recipeList =viewModel.getAllnameTeam()
       // Log.e("view",recipeList.toString())
        var TeamName:ArrayList<String> = arrayListOf()
        var TeamList:ArrayList<Team>
        apiService.getAllNameTeam().enqueue(object : Callback<ArrayList<Team>> {

            override fun onResponse(call: Call<ArrayList<Team>>?, response: Response<ArrayList<Team>?>)  {

                TeamList = response.body()!!

                TeamList.forEach {
                    Log.e("team",it.toString())
                    TeamName.add(it.team_name)

                }
                affiche(TeamName)



            }
            override fun onFailure(call: Call<ArrayList<Team>>, t: Throwable) {
                Log.e("tag",t.message)
                Log.e("tag",t.cause.toString())

                error("KO")

            }
            })


    }
    fun affiche(team:ArrayList<String>){
        listView = this.findViewById(R.id.listview)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, team)
        listView.adapter = adapter

    }
}
