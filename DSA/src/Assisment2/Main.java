package Assisment2;

public class Main {
    public static void main(String[] args) {
        LinkedList ll =  new LinkedList();
        Product p1 = new Product(12,200,800);
        Product p2 = new Product(15,230,803);
        Product p3 = new Product(123,210,8010);
        Product p4 = new Product(12,203,802);
        Product p5 = new Product(1212,2010,810);
        ll.insertIntoLL(p1);
        ll.insertIntoLL(p2);
        ll.insertIntoLL(p3);
        ll.insertIntoLL(p4);
        ll.insertIntoLL(p5);
        ll.display(ll.getHead());


    }
}
