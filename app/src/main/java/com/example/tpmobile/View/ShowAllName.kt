package com.example.tpmobile.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tpmobile.R
import com.example.tpmobile.View.ui.showallname.ShowAllNameFragment

class ShowAllName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_all_name_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ShowAllNameFragment.newInstance())
                .commitNow()
        }
    }

}
