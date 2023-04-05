package com.example.farmaexpress

class CarritoDeComprasSingleton {
    object CarritoDeComprasSingleton {
        private val productos = mutableListOf<Producto>()

        fun agregarProducto(producto: Producto) {
            productos.add(producto)
        }

        fun obtenerProductos(): MutableList<Producto> {
            return productos
        }

        fun getTotal(): Double {
            return productos.sumByDouble { it.precio }
        }
        fun limpiarcarrito(){
            productos.clear()
        }
        fun comprar() {
            productos.clear()
        }
    }

}