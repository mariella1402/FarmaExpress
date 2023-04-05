package com.example.farmaexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class menu : AppCompatActivity() {
    private lateinit var btCS: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btCS= findViewById(R.id.cerrarsesion)
        btCS.setOnClickListener{
            this.CerrarSesion()
        }
    }

    private fun CerrarSesion(){
        finish()
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}