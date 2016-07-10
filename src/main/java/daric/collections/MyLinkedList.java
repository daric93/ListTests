package daric.collections;

import java.util.AbstractList;

public class MyLinkedList<E> extends AbstractList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E i, Node<E> next) {
            this.prev = prev;
            this.item = i;
            this.next = next;
        }
    }

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
        int count = 0;
        Node<E> cur = first;
        while (count != index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            Node<E> l = last;
            Node<E> newNode = new Node<>(l, element, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else l.next = newNode;
        } else {
            if (index == 0) {
                Node<E> f = first;
                Node<E> newNode = new Node<>(null, element, f);
                first = newNode;
                if (f == null)
                    last = newNode;
                else f.prev = newNode;
            } else {
                Node<E> node = getNode(index);
                Node<E> newNode = new Node<>(node.prev, element, node);
                node.prev.next = newNode;
                node.prev = newNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNode(index);
        if (node.prev == null) {
            first = node.next;
            node.next.prev = null;
        } else {
            if (node.next == null) {
                last = node.prev;
                node.prev.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        size--;
        return node.item;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldItem = node.item;
        node.item = element;
        return oldItem;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}
