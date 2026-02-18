package co.edu.uptc.model;

import java.util.List;

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
	public List<Producto> obtenerProductos() {
		return productos.toList();
	}

	@Override
	public List<Producto> obtenerProductosOrdenadosPorNombre() {
		return productos.sortedByDescripcion();
	}

	@Override
	public int eliminarPorNombreParcial(String texto) {
		return productos.removeByDescripcionContains(texto);
	}
}
