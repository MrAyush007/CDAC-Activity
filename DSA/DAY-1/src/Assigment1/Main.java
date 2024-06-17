package Assigment1;

public class Main {
    public static void main(String[] args) {

        LinkedList  ll = new LinkedList();

        ll.insertIntoLL(8);
        ll.insertIntoLL(1);
        ll.insertIntoLL(2);
        ll.insertIntoLL(5);
        ll.insertIntoLL(7);
        ll.insertIntoLL(4);

        LinkedList.display(ll.getHead());
        System.out.println("ANSWER");
        System.out.println("MAX Value "+ll.maxEle(ll.getHead()));
        System.out.println("Min value " + ll.mimEle(ll.getHead()));
        System.out.println("SUM " +ll.sumEle(ll.getHead()));

    }
}
//find the following from the singlele ll
//1 find max ele
//2 find min ele
//3 find sum of all even num
//4 8 1 2 5 7 4 null