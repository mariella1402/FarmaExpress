package com.example.farmaexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.farmaexpress.databinding.ActivityHistorialComprasBinding
import com.example.farmaexpress.Producto
import com.example.farmaexpress.R
import com.example.farmaexpress.databinding.CarritoComprasBinding

class HistorialComprasActivity : AppCompatActivity() {
    private lateinit var binding: CarritoComprasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_compras)

        val listaProductos = mutableListOf<Producto>()

        listaProductos.addAll(HistorialDeComprasSingleton.Historia.obtenerProductos())

        val adapter = ProductoAdapter(this, listaProductos)
        val listView = findViewById<ListView>(R.id.listaHistorial)
        listView.adapter = adapter
    }
}
