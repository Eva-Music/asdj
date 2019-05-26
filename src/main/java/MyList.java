import java.util.Comparator;

public class MyList<Type> {

    private int size;
    private Object[] myType;

    public MyList(int capacity) {
        size = 0;
        myType = new Object[capacity];
    }

    public void add(Type type) {
        if (size == myType.length) {
            resize(size * 2);
        }
        myType[size] = type;
        size++;
    }

    private void resize(int newSize) {
        Object[] temp = new Object[newSize];
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

                if (size == myType.length / 4 && size > 0) {
                    resize(myType.length / 2);
                }
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

    private void change(int index1, int index2) {
        Object t = myType[index1];
        myType[index1] = myType[index2];
        myType[index2] = t;
    }

    private boolean lessen(Type type1, Type type2, Comparator<Type> comp) {
        return comp.compare(type1, type2) < 0;
    }

    public void sortSelect(Comparator<Type> comp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (lessen((Type) myType[j], (Type) myType[min], comp)) {
                    min = j;
                }
            }
            change(i, min);
        }
    }

    public void sortInsert(Comparator<Type> comp) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (lessen((Type) myType[j], (Type) myType[i], comp)) {
                    change(i, j);
                } else {
                    break;
                }
            }
        }
    }

    public void sortBubble(Comparator<Type> comp) {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (lessen((Type) myType[j + 1], (Type) myType[j], comp)) {
                    change(j, j + 1);

                }
            }
        }
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
