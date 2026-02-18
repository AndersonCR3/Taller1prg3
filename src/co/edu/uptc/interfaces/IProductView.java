package co.edu.uptc.interfaces;

import java.util.List;

import co.edu.uptc.pojo.Producto;

public interface IProductView {
    int mostrarMenu();

    Producto solicitarProducto();

    void mostrarProductos(List<Producto> productos, String titulo);

    void mostrarMensaje(String mensaje);

    String solicitarTexto(String mensaje);
}
