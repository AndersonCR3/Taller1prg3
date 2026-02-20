package co.edu.uptc;

import co.edu.uptc.interfaces.IOrderModel;
import co.edu.uptc.interfaces.IProductView;
import co.edu.uptc.model.Order;
import co.edu.uptc.model.OrderLinkedList;
import co.edu.uptc.presenter.ProductPresenter;
import co.edu.uptc.view.ConsoleProductView;

public class App {
    public static void main(String[] args) {
        // Option 1: Use Node and ManagerList (custom linked list)
        IOrderModel model = new Order();
        
        // Option 2: Use Java's LinkedList
        
         //IOrderModel model = new OrderLinkedList();
        
        IProductView view = new ConsoleProductView();
        ProductPresenter presenter = new ProductPresenter(model, view);
        presenter.start();
    }
}
