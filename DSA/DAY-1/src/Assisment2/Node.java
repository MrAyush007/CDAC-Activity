package Assisment2;

public class Node {
    private Product val;
     private  Node next;

    public Node(Product val) {
        this.val = val;
        next=null;
    }

    public Node() {
    }

    public Product getVal() {

        return val;
    }


    public Node getNext() {
        return next;
    }

    public void setVal(Product val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
