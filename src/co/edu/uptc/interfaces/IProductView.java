package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Producto;

public interface IProductView {
    int mostrarMenu();

    Producto solicitarProducto();

    void mostrarProductos(Producto[] productos, String titulo);

    void mostrarMensaje(String mensaje);

    String solicitarTexto(String mensaje);
}
