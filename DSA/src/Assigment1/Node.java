package Assigment1;

public class Node {
    private int val;
     private  Node next;

    public Node(int val) {
        this.val = val;
        next=null;
    }

    public Node() {
    }

    public int getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
