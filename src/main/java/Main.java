public class Main {
    public static void main(String[] args) {

        MyList<Integer> my = new MyList<Integer>(3);

        my.add(1);
        my.add(6);
        System.out.println(my);
        my.add(5);
        my.add(7);
        System.out.println(my);
        my.remove(7);
        System.out.println(my);
        System.out.println(my.get(2));

        my.set(2, 3);
        System.out.println(my);

        System.out.println(my.contains(5));
        System.out.println(my.indexOf(6));

    }
}
