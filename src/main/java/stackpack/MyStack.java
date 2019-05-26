package stackpack;

public class MyStack<Type> {

    private int size;
    private Object[] myStack;

    public MyStack() {
        size = 0;
        myStack = new Object[1];
    }

    public int size() {
        return size;

    }

    public boolean isEmpty() {
        return size == -1;
    }


    private void resize(int newSize) {
        Object[] temp = new Object[newSize];
        System.arraycopy(myStack, 0, temp, 0, myStack.length);
        myStack = temp;
    }


    public void push(Type type) {
        if (size == myStack.length) {
            resize(size * 2);
        }
        myStack[size++] = type;
    }

    public void reverse() {
        Object[] rev = new Object[myStack.length];
        int count = size;
        for (int i = 0; i < count; i++) {
            rev[i] = myStack[--size];
        }
        size = count;
        myStack = rev;
    }

    public Type pop() {
        return (Type) myStack[--size];
    }

    public Type peek() {
        return (Type) myStack[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(myStack[i]).append(" ");
        }
        return sb.toString();
    }
}


