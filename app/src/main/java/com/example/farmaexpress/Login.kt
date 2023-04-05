package com.example.farmaexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var btnLogin: ImageButton
    private lateinit var textviewregistro: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth= FirebaseAuth.getInstance()

        btnLogin= findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
        val email= findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
        val password= findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            this.login(email, password)

        }

        textviewregistro= findViewById(R.id.Irregistro)
        textviewregistro.setOnClickListener{
            this.irRegistro()
        }

    }
   private fun login(email: String, password: String){
       auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
           if (task.isSuccessful){
               Toast.makeText(this, "El usuario se ha logueado", Toast.LENGTH_LONG).show()
               val intent =  Intent(this, menu::class.java)
               startActivity(intent)
               finish()

           }

       }.addOnFailureListener{ exception ->
           Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show()

       }
   }

    private fun irRegistro(){
        val intent = Intent(this, Registro::class.java)
        startActivity(intent)
    }
}