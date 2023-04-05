package com.example.farmaexpress

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.farmaexpress.databinding.CarritoComprasBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CarritoDeCompras : AppCompatActivity() {
    private lateinit var binding: CarritoComprasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CarritoComprasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaProductos = mutableListOf<Producto>()

        listaProductos.addAll(CarritoDeComprasSingleton.CarritoDeComprasSingleton.obtenerProductos())

        val adapter = ProductoAdapter(this, listaProductos)
        val listView = findViewById<ListView>(R.id.listaProductos)
        listView.adapter = adapter

        binding.btnComprar.setOnClickListener {
            HistorialDeComprasSingleton.Historia.agregarProducto(CarritoDeComprasSingleton.CarritoDeComprasSingleton.obtenerProductos())

            Toast.makeText(
                this,
                "Producto Comprados y añadidos al historial",
                Toast.LENGTH_SHORT
            ).show()
            CarritoDeComprasSingleton.CarritoDeComprasSingleton.limpiarcarrito()
            val intent = Intent(this, HistorialComprasActivity::class.java)
            startActivity(intent)
        }

        binding.btnHistorial.setOnClickListener {
            val intent = Intent(this, HistorialComprasActivity::class.java)
            startActivity(intent)
        }

    }

}