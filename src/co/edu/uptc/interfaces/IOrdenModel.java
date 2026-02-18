package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Producto;

public interface IOrdenModel {
    void agregarProducto(Producto producto);

    Producto[] obtenerProductos();

    Producto[] obtenerProductosOrdenadosPorNombre();

    int eliminarPorNombreParcial(String texto);
}
