package co.edu.uptc;

import co.edu.uptc.interfaces.IOrdenModel;
import co.edu.uptc.interfaces.IProductView;
import co.edu.uptc.model.Orden;
import co.edu.uptc.model.OrdenLinkedList;
import co.edu.uptc.presenter.ProductPresenter;
import co.edu.uptc.view.ConsoleProductView;

public class App {
    public static void main(String[] args) {
        // Opcion 1: Usar Node y ManagerList (lista enlazada propia)
        IOrdenModel model = new Orden();
        
        // Opcion 2: Usar LinkedList de Java
        
         //IOrdenModel model = new OrdenLinkedList();
        
        IProductView view = new ConsoleProductView();
        ProductPresenter presenter = new ProductPresenter(model, view);
        presenter.iniciar();
    }
}
