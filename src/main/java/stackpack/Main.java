package stackpack;

public class Main {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack);

        stack.reverse();
        System.out.println(stack);


        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println(queue.size());
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.size());
        queue.insert(5);
        queue.insert(6);
        System.out.println(queue.remove());
        System.out.println(queue.remove());


        Deque<Integer> dec = new Deque<>();
        dec.insertLeft(1);
        dec.insertRight(3);
        dec.insertLeft(2);
        dec.insertRight(4);
        dec.insertRight(5);

        System.out.println(dec.removeLeft());
        System.out.println(dec.removeRight());

        System.out.println(dec.peekLeft());
        System.out.println(dec.peekRight());
    }
}
