package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

public interface IProductView {
    int displayMenu();

    Product requestProduct();

    void displayProducts(Product[] products, String title);

    void displayMessage(String message);

    String requestText(String message);
}
