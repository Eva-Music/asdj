package myhash;

public class MyHashMapStep<Key, Value> {

    private int M = 13;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int h = hash(key);
        for (int i = h; keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int i;
        int step = 1;
        for (i = hash(key); keys[i] != null; i = ((i + step) % M)) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            step = (int) Math.pow(++step, 2);
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

}
