package linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Element> implements Iterable<Element> {

    private int size;
    private Item first;
    private Item last;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public Iterator<Element> iterator() {
        return new LinkedListIterator();
    }

    public int size() {
        return size;
    }

    public void addFirst(Element element) {
        Item oldFirst = first;
        first = new Item(element, oldFirst, null);
        if (size == 0) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public Element getFirst() {
        return first.element;
    }

    public Element removeFirst() {
        Item after = first.next;
        Element removedElement = first.element;
        first.next = null;
        first = after;
        size--;
        if (size == 0) {
            last = null;
        } else {
            first.previous = null;
        }
        return removedElement;
    }

    public Element getLast() {
        return last.element;
    }

    public void addLast(Element element) {
        Item oldLast = last;
        last = new Item(element, null, oldLast);
        if (size == 0) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Element removeLast() {
        Element removedElement = last.element;
        Item oldLastPrevious = last.previous;
        last.previous = null;
        last = oldLastPrevious;
        size--;
        if (size == 0) {
            first = null;
        } else {
            last.next = null;
        }
        return removedElement;
    }

    public Element get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if ((size - index) > index) {
            int count = 0;
            Item currentItem = first;
            while (count < index) {
                currentItem = currentItem.next;
                count++;
            }
            return currentItem.element;
        } else {
            int count = size - index - 1;
            Item currentItem = last;
            while (count > 0) {
                currentItem = currentItem.previous;
                count--;
            }
            return currentItem.element;
        }
    }

    public void set(int index, Element element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Item currentItem = first;
        while (count < index) {
            count++;
            currentItem = currentItem.next;
        }
        currentItem.element = element;
    }

    public int indexOf(Element element) {
        Item currentItem = first;
        int count = 0;
        while (currentItem != null && !currentItem.element.equals(element)) {
            count++;
            currentItem = currentItem.next;
        }
        return currentItem == null ? -1 : count;
    }

    public boolean contains(Element element) {
        return indexOf(element) != -1;
    }

    public Element remove(Element element) {
        Item currentItem = first;
        while (currentItem != null && !currentItem.element.equals(element)) {
            currentItem = currentItem.next;
        }
        if (currentItem == null) {
            return null;
        } else if (currentItem == first) {
            return removeFirst();
        } else if (currentItem == last) {
            return removeLast();
        } else {
            currentItem.previous.next = currentItem.next;
            currentItem.next.previous = currentItem.previous;
            currentItem.previous = null;
            currentItem.next = null;
            size--;
            return currentItem.element;
        }
    }

    public void add(int index, Element element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Item currentItem = first;
            int count = 0;
            while (count < index) {
                count++;
                currentItem = currentItem.next;
            }
            Item newItem = new Item(element, currentItem, currentItem.previous);
            currentItem.previous.next = newItem;
            currentItem.previous = newItem;
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Item current = first;
        while (current != null) {
            sb.append(current.element.toString());
            sb.append(", ");
            current = current.next;
        }
        return sb.toString();
    }

    private class LinkedListIterator implements Iterator<Element> {
        private Item cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Element next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Element element = cursor.element;
            cursor = cursor.next;
            return element;
        }
    }

    private class Item {
        Element element;
        Item next;
        Item previous;

        Item(Element element, Item next, Item previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
}
