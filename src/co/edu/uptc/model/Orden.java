package co.edu.uptc.model;

import co.edu.uptc.interfaces.IOrdenModel;
import co.edu.uptc.pojo.Producto;

public class Orden implements IOrdenModel {
	private final ProductListAdapter productos;

	public Orden() {
		this.productos = new ProductListAdapter();
	}

	@Override
	public void agregarProducto(Producto producto) {
		productos.addProducto(producto);
	}

	@Override
	public Producto[] obtenerProductos() {
		return productos.toArray();
	}

	@Override
	public Producto[] obtenerProductosOrdenadosPorNombre() {
		return productos.sortedByDescripcion();
	}

	@Override
	public int eliminarPorNombreParcial(String texto) {
		return productos.removeByDescripcionContains(texto);
	}
}
