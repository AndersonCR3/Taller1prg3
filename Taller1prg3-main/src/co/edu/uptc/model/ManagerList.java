package co.edu.uptc.model;

import co.edu.uptc.pojo.Product;

public class ManagerList {
    Node header = null;

    private Node createNode(String value) { return new Node(value); }

    private Node returnLastNode(){
        Node last = header;
        while (last.next!= null){
            last = last.next;
        }
        return last;
    }

    public void addStart(String value){
        Node aux = createNode(value);
        if (header == null){
            header = aux;
        } else {
            aux.next = header;
            header = aux;
        }
    }
    public void addEnd(String value){
        Node aux = createNode(value);
        if (header == null){
            header = aux;
        } else {
            Node last = returnLastNode();
            last.next = aux;
        }
    }

    public void showList(){
        Node aux = header;
        while (aux != null){
            System.out.println(aux.value + " " + aux.value.length());
            aux = aux.next;
        }
    }
}
