package com.example.farmaexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.farmaexpress.databinding.ActivityProductoBinding

class ProductoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val producto = intent.getSerializableExtra("producto") as Producto

        binding.nombreProducto.text = producto.nombre
        binding.precioProducto.text = "$${producto.precio}"
        binding.indicacionesProducto.text = producto.indicacion
        binding.contraindicacionesProducto.text = producto.contraindicacion
        binding.imageView2.setImageResource(producto.inagen)


        binding.btnComprar.setOnClickListener {
            CarritoDeComprasSingleton.CarritoDeComprasSingleton.agregarProducto(producto)
            Toast.makeText(
                this,
                "Producto ${producto.nombre} añadido al carrito de compras",
                Toast.LENGTH_SHORT
            ).show()

            //val intent = Intent(this, CarritoDeCompras::class.java)
            //intent.putExtra("productoCarrito", producto)
            //startActivity(intent)
        }

    }
}
