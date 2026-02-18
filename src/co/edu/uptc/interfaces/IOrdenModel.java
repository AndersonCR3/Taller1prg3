package co.edu.uptc.interfaces;

import java.util.List;

import co.edu.uptc.pojo.Producto;

public interface IOrdenModel {
    void agregarProducto(Producto producto);

    List<Producto> obtenerProductos();

    List<Producto> obtenerProductosOrdenadosPorNombre();

    int eliminarPorNombreParcial(String texto);
}
