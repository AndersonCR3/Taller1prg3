package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.IOrdenModel;
import co.edu.uptc.interfaces.IProductView;
import co.edu.uptc.pojo.Producto;

public class ProductPresenter {
    private final IOrdenModel model;
    private final IProductView view;

    public ProductPresenter(IOrdenModel model, IProductView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        boolean ejecutar = true;
        while (ejecutar) {
            int opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Producto producto = view.solicitarProducto();
                    model.agregarProducto(producto);
                    view.mostrarMensaje("Producto agregado.");
                    break;
                case 2:
                    view.mostrarProductos(model.obtenerProductos(), "Lista de productos");
                    break;
                case 3:
                    view.mostrarProductos(model.obtenerProductosOrdenadosPorNombre(), "Lista ordenada por nombre");
                    break;
                case 4:
                    String texto = view.solicitarTexto("Ingrese nombre o parte del nombre a borrar: ");
                    int eliminados = model.eliminarPorNombreParcial(texto);
                    view.mostrarMensaje("Productos eliminados: " + eliminados);
                    break;
                case 0:
                    ejecutar = false;
                    break;
                default:
                    view.mostrarMensaje("Opcion invalida.");
                    break;
            }
        }
    }
}
