package com.example.tpmobile.View.ui.showallname

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tpmobile.R

class RecycleViewAllTeam (private val data :ArrayList<String>
) : RecyclerView.Adapter<RecycleViewAllTeam.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_fragment,parent,false)
        return  ViewHolder(v)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: String = data[position]

        holder.text1.text=data.nomville
        holder.text2.text="Nombre Touriste :"+data.nbtouriste.toString()
        holder.mView.setOnClickListener{ itemView ->
            val bundle = Bundle()
            bundle.putInt("position",position)

            itemView.findNavController().navigate(R.id.action_fragmentFragment_to_fragmentDeatil, bundle)


        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val text1 =itemView.text1 as TextView
        val text2 =itemView.text2 as TextView




    }
}
