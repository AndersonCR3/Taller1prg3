package co.edu.uptc.model;

import java.util.Comparator;
import java.util.LinkedList;

import co.edu.uptc.interfaces.IOrderModel;
import co.edu.uptc.pojo.Product;

public class OrderLinkedList implements IOrderModel {
    private final LinkedList<Product> products;

    public OrderLinkedList() {
        this.products = new LinkedList<>();
    }

    @Override
    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    @Override
    public Product[] getProducts() {
        return products.toArray(new Product[0]);
    }

    @Override
    public Product[] getProductsSortedByName() {
        LinkedList<Product> sorted = new LinkedList<>(products);
        sorted.sort(Comparator.comparing(Product::getDescription, String.CASE_INSENSITIVE_ORDER));
        return sorted.toArray(new Product[0]);
    }

    @Override
    public int removeByPartialName(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String criteria = text.trim().toLowerCase();
        int sizeBefore = products.size();
        products.removeIf(product -> product.getDescription().toLowerCase().contains(criteria));
        return sizeBefore - products.size();
    }
}
