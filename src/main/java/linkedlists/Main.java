package linkedlists;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(5);
        myLinkedList.add(1, 1);
        myLinkedList.addLast(6);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.indexOf(5));
        myLinkedList.addFirst(2);
        myLinkedList.addLast(8);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(4));
//        myLinkedList.removeFirst();
//        myLinkedList.removeLast();
        //   System.out.println(myLinkedList);
        for (Integer i : myLinkedList) {
            System.out.print(i + " ");
        }

    }
}
