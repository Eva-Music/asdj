package linkedlists;

public class DelegateDeque<Element> {
    private MyLinkedList<Element> linkedDeque = new MyLinkedList<>();

    public int size() {
        return linkedDeque.size();
    }

    public void insertLeft(Element element) {
        linkedDeque.addFirst(element);
    }

    public void insertRight(Element element) {
        linkedDeque.addLast(element);
    }

    public void removeLeft() {
        linkedDeque.removeFirst();
    }

    public void removeRight() {
        linkedDeque.removeLast();
    }

    public Element peekLeft() {
        return linkedDeque.getFirst();
    }

    public Element peekRight() {
        return linkedDeque.getLast();
    }

}
