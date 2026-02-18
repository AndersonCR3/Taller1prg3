package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
    public List<Producto> obtenerProductos() {
        return new ArrayList<>(productos);
    }

    @Override
    public List<Producto> obtenerProductosOrdenadosPorNombre() {
        List<Producto> ordenados = new ArrayList<>(productos);
        ordenados.sort(Comparator.comparing(Producto::getDescripcion, String.CASE_INSENSITIVE_ORDER));
        return ordenados;
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
