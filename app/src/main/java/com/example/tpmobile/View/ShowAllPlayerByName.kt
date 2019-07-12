package com.example.tpmobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.tpmobile.Model.ApiService.ApiService
import com.example.tpmobile.Model.Player
import com.example.tpmobile.Model.Team
import com.example.tpmobile.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowAllPlayerByName : AppCompatActivity() {

    private lateinit var listView : ListView


    private var apiService = ApiService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_player)

        this.apiService = ApiService.create()
        var PlayerList:ArrayList<Player>
        var  PlayerName:ArrayList<String> = arrayListOf()

        var Team_name: String = intent.getStringExtra("TeamName")

        apiService.getAllPlayeByNameTeam(Team_name).enqueue(object : Callback<ArrayList<Player>> {
            override fun onResponse(call: Call<ArrayList<Player>>?, response: Response<ArrayList<Player>?>) {
                PlayerList = response.body()!!
                PlayerList.forEach {
                    PlayerName.add(it.first_name)
                }
                Log.e("TeamNameMustaphaIN",PlayerName.toString())
                AfficherPlayer(PlayerName)
            }
            override fun onFailure(call: Call<ArrayList<Player>>, t: Throwable) {
                Log.e("tag",t.message)
                Log.e("tag",t.cause.toString())
                error("KO")
            }
        })


    }

    fun AfficherPlayer(playerName :ArrayList<String>){
        listView = findViewById<ListView>(R.id.listviewplayerbyteamname)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, playerName)
        listView.adapter = adapter
    }
}
