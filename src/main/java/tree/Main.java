package tree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int balanced = 0;
        int unbalanced = 0;
        for (int i = 0; i < 20; i++) {
            MyTree<Integer, Integer> myTree = new MyTree<>();
            while (true) {
                myTree.put(random.nextInt(100), 3);
                if (myTree.height() == 6) {
                    break;
                }
            }

            if (myTree.isBalanced()) {
                balanced++;
            } else {
                unbalanced++;
            }
        }

        if (balanced == 0) {
            System.out.println(100 + "%" + " unbalanced");
        } else {
            int res = unbalanced / balanced * 100;
            System.out.println(res + "%" + " unbalanced");
        }

    }
}
