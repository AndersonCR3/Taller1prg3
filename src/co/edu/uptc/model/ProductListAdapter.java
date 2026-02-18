package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import co.edu.uptc.pojo.Producto;

public class ProductListAdapter {
    private static final String SEPARATOR = "|";
    private final ManagerList list;

    public ProductListAdapter() {
        this.list = new ManagerList();
    }

    public void addProducto(Producto producto) {
        if (producto == null) {
            return;
        }
        list.addEnd(serialize(producto));
    }

    public List<Producto> toList() {
        List<Producto> productos = new ArrayList<>();
        Node current = list.header;
        while (current != null) {
            Producto producto = deserialize(current.value);
            if (producto != null) {
                productos.add(producto);
            }
            current = current.sig;
        }
        return productos;
    }

    public List<Producto> sortedByDescripcion() {
        List<Producto> productos = toList();
        productos.sort(Comparator.comparing(Producto::getDescripcion, String.CASE_INSENSITIVE_ORDER));
        return productos;
    }

    public int removeByDescripcionContains(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        String criterio = texto.trim().toLowerCase();
        int removed = 0;
        Node prev = null;
        Node current = list.header;
        while (current != null) {
            Producto producto = deserialize(current.value);
            boolean match = producto != null && producto.getDescripcion().toLowerCase().contains(criterio);
            if (match) {
                removed++;
                if (prev == null) {
                    list.header = current.sig;
                    current = list.header;
                } else {
                    prev.sig = current.sig;
                    current = prev.sig;
                }
                continue;
            }
            prev = current;
            current = current.sig;
        }
        return removed;
    }

    private String serialize(Producto producto) {
        return producto.getDescripcion() + SEPARATOR
                + producto.getPrecio() + SEPARATOR
                + producto.getUnidadMedida();
    }

    private Producto deserialize(String value) {
        if (value == null) {
            return null;
        }
        String[] parts = value.split("\\|", 3);
        if (parts.length < 3) {
            return null;
        }
        try {
            double precio = Double.parseDouble(parts[1]);
            return new Producto(parts[0], precio, parts[2]);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
