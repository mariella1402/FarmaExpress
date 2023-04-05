package com.example.farmaexpress

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.farmaexpress.databinding.ItemProductoBinding

class ProductoAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(mContext), parent, false)
        val producto = listaProductos[position]

        binding.nombreProducto.text = producto.nombre
        binding.precio.text = "$${producto.precio}"
        binding.imagenProd.setImageResource(producto.inagen)

        return binding.root
    }
}
