package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.IOrderModel;
import co.edu.uptc.interfaces.IProductView;
import co.edu.uptc.pojo.Product;

public class ProductPresenter {
    private final IOrderModel model;
    private final IProductView view;

    public ProductPresenter(IOrderModel model, IProductView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            int option = view.displayMenu();
            switch (option) {
                case 1:
                    Product product = view.requestProduct();
                    model.addProduct(product);
                    view.displayMessage("Producto añadido.");
                    break;
                case 2:
                    view.displayProducts(model.getProducts(), "Lista de productos");
                    break;
                case 3:
                    view.displayProducts(model.getProductsSortedByName(), "Lista ordenada por nombre");
                    break;
                case 4:
                    String text = view.requestText("Digite el nombre del producto a eliminar: ");
                    int deleted = model.removeByPartialName(text);
                    view.displayMessage("Productos eliminados: " + deleted);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    view.displayMessage("Opción inválida.");
                    break;
            }
        }
    }
}
