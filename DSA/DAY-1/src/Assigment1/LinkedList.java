package Assigment1;

public class LinkedList {
    private Node head;
    private  Node tail;
    int size;

    public LinkedList() {
       head=tail=null;
    }

    public void insertIntoLL(int val)
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
    public static void display(Node temp)
    {
       while(temp!=null){
           System.out.println(temp.getVal());
           temp = temp.getNext();
       }
    }
    public int maxEle(Node temp){
        int ans=0;
        while(temp!=null){
            if(temp.getVal()>ans){
                ans=temp.getVal();
            }
            temp=temp.getNext();
        }
        return ans;
    }
    public  int mimEle(Node temp){
        int ans=9999;
        while(temp!=null){
            if(temp.getVal()<ans){
                ans=temp.getVal();
            }
            temp=temp.getNext();
        }
        return ans;
    }
    public int sumEle(Node temp){
        int ans=0;
        while(temp!=null){
                ans+=temp.getVal();
            temp=temp.getNext();
        }
        return ans;
    }

    public  Node getHead() {
        return head;
    }

    public  Node getTail() {
        return tail;
    }
}
