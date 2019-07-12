package com.example.tpmobile.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tpmobile.Model.Player
import com.example.tpmobile.Model.Team
import com.example.tpmobile.Repo.RepoTeam

class ViewModelTeam:ViewModel() {
    var teamRep:RepoTeam= RepoTeam()

    private val AllNameTeamm:MutableLiveData<ArrayList<String>> = MutableLiveData()
    private val AllPlayerTeamm:MutableLiveData<ArrayList<Player>> = MutableLiveData()


   fun  getAllNameTeamFromRepo(NameTeam:String): MutableLiveData<ArrayList<Player>> {
       this.AllPlayerTeamm.postValue(teamRep.getListPlayerByNameTeam(NameTeam))
       return this.AllPlayerTeamm
   }
   fun CreatTeam(team: Team){
       this.teamRep.CreateTeam(team)
   }






}