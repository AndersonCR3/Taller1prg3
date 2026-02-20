package co.edu.uptc.model;

import co.edu.uptc.interfaces.IOrderModel;
import co.edu.uptc.pojo.Product;

public class Order implements IOrderModel {
	private final ProductListAdapter products;

	public Order() {
		this.products = new ProductListAdapter();
	}

	@Override
	public void addProduct(Product product) {
		products.addProduct(product);
	}

	@Override
	public Product[] getProducts() {
		return products.toArray();
	}

	@Override
	public Product[] getProductsSortedByName() {
		return products.sortedByDescription();
	}

	@Override
	public int removeByPartialName(String text) {
		return products.removeByDescriptionContains(text);
	}
}
