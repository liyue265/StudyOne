package com.cont.mystudy;

public class LinkedList<E> {

    private Node first;
    private Node last;
    public int size;

    public LinkedList() {
    }

    public void add(E data) {
        Node<E> eNode = new Node<E>(last, data, null);
        Node<E> oldLast = last;
        last = eNode;

        if (oldLast == null) {
            first = eNode;
        } else {
            oldLast.next = eNode;
        }
        size++;
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            add(data);
        } else {
            Node<E> node = getNodeByIndex(index);
            Node<E> pre = node.pre;
            Node<E> eNode = new Node<>(pre, data, node);
            if (pre == null) {
                first = eNode;
            } else {
                pre.next = eNode;
            }
            pre = eNode;
            size++;
        }
    }

    public Node<E> get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("下标越界");
        }
        return getNodeByIndex(index);
    }

    public Node<E> getNodeByIndex(int index) {
        Node node = null;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
        }
        return node;
    }

    public static class Node<E> {
        Node<E> pre;
        E data;
        Node<E> next;

        public Node(Node<E> pre, E data, Node<E> next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }


}
