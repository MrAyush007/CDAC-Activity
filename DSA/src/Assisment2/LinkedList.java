package Assisment2;

public class LinkedList {
    private Node head;
    private Node tail;
    int size;

    public LinkedList() {
       head=tail=null;
    }

    public void insertIntoLL(Product val)
    {
        Node n1 = new Node(val);
        if(head==null){
           tail=head=n1;
        }
        else {
            tail.setNext(n1);
            tail = n1;
        }
    }
    public  void display(Node temp)
    {
       while(temp!=null){
           System.out.println(temp.getVal());
           temp = temp.getNext();
       }
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
