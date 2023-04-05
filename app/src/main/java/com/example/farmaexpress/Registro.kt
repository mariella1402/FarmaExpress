package com.example.farmaexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Registro : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
private lateinit var btnRegistro:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        auth= FirebaseAuth.getInstance()

        btnRegistro=findViewById<Button>(R.id.btnregistro)
        btnRegistro.setOnClickListener{
            val email=findViewById<EditText>(R.id.editTextTextEmailAddress3).text.toString()
            val password=findViewById<EditText>(R.id.editTextTextPassword3).text.toString()
            this.register(email,password)
        }
    }

    private fun register(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
            if (task.isSuccessful){
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }

        }.addOnFailureListener{ exception ->
            Toast.makeText(this, "El usuario se registró correctamente", Toast.LENGTH_LONG).show()
        }
    }
}
