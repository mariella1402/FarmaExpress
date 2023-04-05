package com.example.farmaexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //FontManager.markAsIconContainer(findViewById(R.id.icons_container), FontManager.getTypeface(this, FontManager.FONTAWESOME));

    }
}
