package co.edu.uptc.pojo;

public class Producto {
    private final String descripcion;
    private final double precio;
    private final String unidadMedida;

    public Producto(String descripcion, double precio, String unidadMedida) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    @Override
    public String toString() {
        return "Descripcion: " + descripcion + " | Precio: " + precio + " | Unidad: " + unidadMedida;
    }
}
