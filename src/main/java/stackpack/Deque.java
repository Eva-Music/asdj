package stackpack;

public class Deque<Type> {

    private Object[] deque;
    private int size;
    private int left;
    private int right;

    public Deque() {
        deque = new Object[4];
        size = 0;
        left = 0;
        right = 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == deque.length;
    }

    public void insertLeft(Type type) {
        if (size == deque.length) {
            resize(size * 2);
        }

        deque[left--] = type;

        if (left < 0) {
            left = deque.length - 1;
        }
        size++;
    }

    public void insertRight(Type type) {
        if (size == deque.length) {
            resize(size * 2);
        }
        deque[++right] = type;

        if (right > size) {
            right = 0;
        }
        size++;
    }


    public Type removeLeft() {
        Type t = (Type) deque[left];
        deque[left] = null;
        left++;
        if (left == size) {
            left = 0;
        }
        size--;

        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return t;
    }


    public Type removeRight() {
        Type t = (Type) deque[right];
        deque[right] = null;
        right--;
        if (right < 0) {
            right = size - 1;
        }
        size--;

        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return t;
    }


    public Type peekRight() {
        return (Type) deque[right];
    }

    public Type peekLeft() {
        return (Type) deque[left];
    }


    public void resize(int newSize) {
        Object[] temp = new Object[newSize];

        for (int i = 0; i < size; i++) {
            temp[i] = deque[(i + left + 1) % deque.length];
        }

        left = 0;
        right = size - 1;
        deque = temp;
    }
}


