package com.example.tpmobile.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tpmobile.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this, ShowAllTeamName::class.java)
            startActivity(intent)


        }
       /* button2.setOnClickListener {
            val intent = Intent(this, ShowAllPlayerByName::class.java)
                startActivity(intent)

        }*/
        button3.setOnClickListener {
            val intent = Intent(this, insertTeam::class.java)
                startActivity(intent)

        }
    }

}
