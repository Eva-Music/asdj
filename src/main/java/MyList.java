public class MyList<Type> {

    private int size;
    private Object[] myType;

    public MyList(int capacity) {
        size = 0;
        myType = new Object[capacity];
    }

    public void add(Type type) {
        if (size == myType.length) {
            resize();
        }
        myType[size] = type;
        size++;
    }

    private void resize() {
        Object[] temp = new Object[size * 2];
        System.arraycopy(myType, 0, temp, 0, myType.length);
        myType = temp;
    }

    public boolean remove(Type type) {
        for (int i = 0; i < myType.length - 1; i++) {
            if (indexOf(type) != -1) {
                for (int j = i; j < myType.length - 1; j++) {
                    myType[j] = myType[j + 1];
                }
                myType[size] = 0;
                size--;
                return true;
            }
        }
        return false;
    }


    public Type get(int index) {
        for (int i = 0; i < myType.length - 1; i++) {
            if (myType[i].equals(myType[index])) {
                return (Type) myType[i];
            }
        }
        return null;
    }

    public void set(int index, Type type) {
        Object[] t = new Object[myType.length + 1];
        System.arraycopy(myType, 0, t, 0, index);
        t[index] = type;
        System.arraycopy(myType, index, t, index + 1, myType.length - index);
        myType = t;
        size++;
    }

    public int indexOf(Type type) {
        for (int i = 0; i < myType.length - 1; i++) {
            if (type.equals(myType[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Type type) {
        return indexOf(type) != -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(myType[i]).append(" ");
        }
        return sb.toString();
    }
}
