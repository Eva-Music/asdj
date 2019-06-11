package recursion;

import stackpack.MyStack;

public class Main {
    public static void main(String[] args) {
        System.out.println(gradeFunc(7, 6));
        System.out.println(cycleFunc(7, 6));

//        MyStack<Integer> havoyStackA = new MyStack<>();
//        MyStack<Integer> havoyStackB = new MyStack<>();
//        MyStack<Integer> havoyStackC = new MyStack<>();
//        for (int i = 0; i < 3; i++) {
//            havoyStackA.push(i);
//        }
//        System.out.println(havoyStackA);
//        hanoy(havoyStackA, havoyStackB, havoyStackC, 3);
//        System.out.println(havoyStackC);
    }

    public static int gradeFunc(int a, int b) {
        if (b == 1 || a == 1) {
            return a;
        }
        return gradeFunc(a, b - 1) * a;
    }

    public static int cycleFunc(int a, int b) {
        int temp = 1;
        for (int i = 0; i < b; i++) {
            temp *= a;
        }
        return temp;
    }


    public static void hanoy(MyStack<Integer> a,
                             MyStack<Integer> b, MyStack<Integer> c, int disks) {
        if (disks == 1) {
            c.push(a.pop());
        } else {
            hanoy(a, c, b, disks - 1);
            c.push(a.pop());
            hanoy(b, a, c, disks - 1);
        }
    }
}

