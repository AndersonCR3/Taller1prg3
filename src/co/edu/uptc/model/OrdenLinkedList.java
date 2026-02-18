package co.edu.uptc.model;

import java.util.Comparator;
import java.util.LinkedList;

import co.edu.uptc.interfaces.IOrdenModel;
import co.edu.uptc.pojo.Producto;

public class OrdenLinkedList implements IOrdenModel {
    private final LinkedList<Producto> productos;

    public OrdenLinkedList() {
        this.productos = new LinkedList<>();
    }

    @Override
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    @Override
    public Producto[] obtenerProductos() {
        return productos.toArray(new Producto[0]);
    }

    @Override
    public Producto[] obtenerProductosOrdenadosPorNombre() {
        LinkedList<Producto> ordenados = new LinkedList<>(productos);
        ordenados.sort(Comparator.comparing(Producto::getDescripcion, String.CASE_INSENSITIVE_ORDER));
        return ordenados.toArray(new Producto[0]);
    }

    @Override
    public int eliminarPorNombreParcial(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        String criterio = texto.trim().toLowerCase();
        int sizeBefore = productos.size();
        productos.removeIf(producto -> producto.getDescripcion().toLowerCase().contains(criterio));
        return sizeBefore - productos.size();
    }
}
