package stackpack;

public class MyQueue<Type> {

    private Object[] myQueue;
    private int size;
    private int start;
    private int end;

    public MyQueue() {
        myQueue = new Object[1];
        size = 0;
        start = 0;
        end = 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == myQueue.length;
    }

    public void insert(Type type) {
        if (size == myQueue.length) {
            resize(size * 2);
        }

        if (end == myQueue.length) {
            end = 0;
        }
        myQueue[end++] = type;

        size++;

    }


    public Type remove() {
        Type t = (Type) myQueue[start];
        myQueue[start] = null;
        size--;
        if (start > size) {
            start = 0;
        } else {
            start++;
        }

        if (size == myQueue.length / 4 && size > 0) {
            resize(myQueue.length / 2);
        }
        return t;
    }


    public Type peek() {
        return (Type) myQueue[start];
    }


    public void resize(int newSize) {
        Object[] temp = new Object[newSize];

        for (int i = 0; i < size; i++) {
            temp[i] = myQueue[(i + start) % myQueue.length];
        }

        start = 0;
        end = size;
        myQueue = temp;
    }
}
