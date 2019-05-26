public class Main {
    public static void main(String[] args) {

        MyList<Integer> my = new MyList<>(3);

        my.add(1);
        my.add(6);
        System.out.println(my);
        my.add(5);
        my.add(3);
        System.out.println(my);
        System.out.println(my.get(2));

        my.set(2, 7);
        System.out.println(my);

        MyList<Integer> my1 = new MyList<>(10000);
        for (int i = 10000; i > 0; i--) {
            my1.add(i);
        }

        MyList<Integer> my2 = new MyList<>(10000);
        for (int i = 10000; i > 0; i--) {
            my2.add(i);
        }

        MyList<Integer> my3 = new MyList<>(10000);
        for (int i = 10000; i > 0; i--) {
            my3.add(i);
        }

        long l = System.currentTimeMillis();
        my1.sortInsert(Integer::compareTo);
        System.out.println(System.currentTimeMillis() - l);


        long l2 = System.currentTimeMillis();
        my2.sortSelect(Integer::compareTo);
        System.out.println(System.currentTimeMillis() - l2);


        long l3 = System.currentTimeMillis();
        my3.sortBubble(Integer::compareTo);
        System.out.println(System.currentTimeMillis() - l3);
    }
}
