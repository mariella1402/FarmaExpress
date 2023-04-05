package com.example.farmaexpress

class HistorialDeComprasSingleton {
    object Historia {
        private val productos = mutableListOf<Producto>()

        fun agregarProducto(producto: MutableList<Producto>) {
            productos.addAll(producto)
        }

        fun obtenerProductos(): MutableList<Producto> {
            return productos
        }

        fun limpiarcarrito(){
            productos.clear()
        }

        fun getTotal(): Double {
            return productos.sumByDouble { it.precio }
        }

        fun comprar() {
            productos.clear()
        }
    }
}