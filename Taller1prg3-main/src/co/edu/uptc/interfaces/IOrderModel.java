package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

public interface IOrderModel {

    void addProduct(Product product);
    Product[] getProducts();
    Product[] getProductsSortedByName();
    int removeByPartialName(String text);
}
