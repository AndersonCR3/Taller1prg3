package co.edu.uptc.model;

public class ManagerList {
    Node header = null;

    private Node createNode(String value) { return new Node(value); }

    private Node returnLaNode(){
        Node last = header;
        while (last.sig!= null){
            last = last.sig;
        }
        return last;
    }

    public void addInicio(String value){
        Node aux = createNode(value);
        if (header == null){
            header = aux;
        } else {
            aux.sig = header;
            header = aux;
        }
    }
    public void addEnd(String value){
        Node aux = createNode(value);
        if (header == null){
            header = aux;
        } else {
            Node last = returnLaNode();
            last.sig = aux;
        }
    }

    public void showList(){
        Node aux = header;
        while (aux != null){
            System.out.println(aux.value + " " + aux.value.length());
            aux = aux.sig;
        }
    }
}
