package co.edu.uptc.model;

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

    public Producto[] toArray() {
        // Contar primero
        int count = 0;
        Node current = list.header;
        while (current != null) {
            count++;
            current = current.sig;
        }

        // Crear array y llenar
        Producto[] productos = new Producto[count];
        current = list.header;
        int index = 0;
        while (current != null) {
            Producto producto = deserialize(current.value);
            if (producto != null) {
                productos[index++] = producto;
            }
            current = current.sig;
        }
        return productos;
    }

    public Producto[] sortedByDescripcion() {
        if (list.header == null) {
            return new Producto[0];
        }

        // Clonar la lista para no modificar la original
        ManagerList sortedList = cloneList();
        
        // Insertion sort sobre los nodos
        sortedList.header = insertionSort(sortedList.header);
        
        // Contar elementos
        int count = 0;
        Node current = sortedList.header;
        while (current != null) {
            count++;
            current = current.sig;
        }

        // Convertir a array
        Producto[] result = new Producto[count];
        current = sortedList.header;
        int index = 0;
        while (current != null) {
            Producto producto = deserialize(current.value);
            if (producto != null) {
                result[index++] = producto;
            }
            current = current.sig;
        }
        return result;
    }

    private ManagerList cloneList() {
        ManagerList cloned = new ManagerList();
        Node current = list.header;
        while (current != null) {
            cloned.addEnd(current.value);
            current = current.sig;
        }
        return cloned;
    }

    private Node insertionSort(Node head) {
        if (head == null || head.sig == null) {
            return head;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.sig;
            sorted = insertSorted(sorted, current);
            current = next;
        }

        return sorted;
    }

    private Node insertSorted(Node sorted, Node newNode) {
        if (sorted == null || compareDescripcion(newNode.value, sorted.value) <= 0) {
            newNode.sig = sorted;
            return newNode;
        }

        Node current = sorted;
        while (current.sig != null && compareDescripcion(newNode.value, current.sig.value) > 0) {
            current = current.sig;
        }

        newNode.sig = current.sig;
        current.sig = newNode;
        return sorted;
    }

    private int compareDescripcion(String value1, String value2) {
        Producto p1 = deserialize(value1);
        Producto p2 = deserialize(value2);
        
        if (p1 == null || p2 == null) {
            return 0;
        }
        
        return p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion());
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
