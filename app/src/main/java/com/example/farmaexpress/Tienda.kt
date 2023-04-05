package com.example.farmaexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Tienda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        val listaProductos = mutableListOf<Producto>()

        listaProductos.add(Producto("Acetaminofen", 0.25, "Quita dolor de cabeza", "Tomar 1 cada 6 horas", "Evitar tomar bajo efectos del alcohol", R.drawable.acetaminofen))
        listaProductos.add(Producto("Ibuprofeno", 0.35, "Alivia el dolor muscular", "Tomar 1 cada 8 horas", "No exceder la dosis recomendada", R.drawable.ibuprofeno))
        listaProductos.add(Producto("Aspirina", 0.45, "Reduce la inflamación", "Tomar 1 cada 12 horas", "No tomar si es alérgico a la aspirina", R.drawable.aspirina))
        listaProductos.add(Producto("Vitaminas C", 0.50, "Fortalece el sistema inmunológico", "Tomar 1 diaria", "No exceder la dosis recomendada", R.drawable.vitamina_c))
        listaProductos.add(Producto("Vitaminas D", 0.60, "Fortalece los huesos", "Tomar 1 diaria", "No exceder la dosis recomendada", R.drawable.vitamina_d))
        listaProductos.add(Producto("Magnesio", 0.70, "Ayuda a relajar los músculos", "Tomar 1 cada 12 horas", "No tomar si tiene problemas renales", R.drawable.magnesio))
        listaProductos.add(Producto("Omega 3", 0.80, "Mejora la salud cardiovascular", "Tomar 1 diaria", "No exceder la dosis recomendada", R.drawable.omega_3))
        listaProductos.add(Producto("Proteína en polvo", 0.90, "Ayuda a desarrollar masa muscular", "Tomar según indicaciones del producto", "No exceder la dosis recomendada", R.drawable.proteina))
        listaProductos.add(Producto("Té verde", 1.00, "Reduce el estrés", "Tomar 1 diaria", "No tomar si es sensible a la cafeína", R.drawable.te_verde))
        listaProductos.add(Producto("Melatonina", 1.10, "Ayuda a conciliar el sueño", "Tomar 1 diaria antes de dormir", "No exceder la dosis recomendada", R.drawable.melatonina))

        val adapter = ProductoAdapter(this, listaProductos)

        val listView = findViewById<ListView>(R.id.Lista)

        val btnCarrito = findViewById<FloatingActionButton>(R.id.btnCarrito)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

        btnCarrito.setOnClickListener {
            val intent = Intent(this, CarritoDeCompras::class.java)
            startActivity(intent)
        }
    }
}
