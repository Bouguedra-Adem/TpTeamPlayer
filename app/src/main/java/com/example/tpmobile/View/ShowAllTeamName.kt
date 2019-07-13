package com.example.tpmobile.View


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
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





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_team_name)


        this.apiService = ApiService.create()
        var TeamList:ArrayList<Team>
        var  TeamName:ArrayList<String> = arrayListOf()
        apiService.getAllNameTeam().enqueue(object : Callback<ArrayList<Team>> {
            override fun onResponse(call: Call<ArrayList<Team>>?, response: Response<ArrayList<Team>?>) {
                TeamList = response.body()!!
                TeamList.forEach {
                    TeamName.add(it.team_name)
                }
                Log.e("TeamNameMustaphaIN",TeamName.toString())
                Afficher(TeamName)

            }
            override fun onFailure(call: Call<ArrayList<Team>>, t: Throwable) {
                Log.e("tag",t.message)
                Log.e("tag",t.cause.toString())

                error("KO")
            }
        })
    }

    fun Afficher( teamName:ArrayList<String>){
        Log.e("FromAfficher",teamName.toString())
        listView = findViewById<ListView>(R.id.listviewteamname)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, teamName)
        listView.adapter = adapter



        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.e("tagmustaphajoure",teamName.get(position))
            val intent = Intent(this, ShowAllPlayerByName::class.java)
            intent.putExtra("TeamName", teamName.get(position))
            startActivity(intent)
        }

      /*  listView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.e("tagmustaphajoure",teamName.get(position))
            val intent = Intent(this, ShowAllPlayerByName::class.java)
            intent.putExtra("Username", teamName.get(position))
            startActivity(intent)
        })*/


    }
}
