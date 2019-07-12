package com.example.tpmobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProviders
import com.example.tpmobile.R
import com.example.tpmobile.ViewModel.ViewModelTeam

class ShowAllTeamName : AppCompatActivity() {
    private lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_team_name)
        val viewModel= ViewModelProviders.of(this).get(ViewModelTeam ::class.java)
        listView = findViewById<ListView>(R.id.listview)
// 1
        var recipeList =viewModel.getAllnameTeam()
        

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, recipeList)
        listView.adapter = adapter
    }
}
