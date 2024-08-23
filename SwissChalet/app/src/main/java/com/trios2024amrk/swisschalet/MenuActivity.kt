package com.trios2024amrk.swisschalet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trios2024amrk.swisschalet.ui.main.MenuFragment

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MenuFragment.newInstance())
                .commitNow()
        }
    }
}