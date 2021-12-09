package LinkedListTester;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T d) {
        data = d;
        next = null;
    }

    public void setData(T d) {
        data = d;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> n) {
        next = n;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class LinkedList<T> {
    Node<T> first;
    Node<T> last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public void add(int d) {
        Node<T> n = new Node(d);
        if (first == null) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
    }

    public void add(int pos, T d) {
        Node<T> n = new Node(d);
        if (pos == 0) {
            n.setNext(first);
            first = n;
        } else {
            Node<T> temp = first;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.getNext();
            }
            n.setNext(temp.getNext());
            temp.setNext(n);
        }
    }

    public void addFirst(T d) {
        Node<T> n = new Node(d);
        n.setNext(first);
        first = n;
    }

    public void addLast(T d) {
        Node<T> n = new Node(d);
        if (first == null) {
            first = n;
            last = n;
        } else {
            last.setNext(n);
            last = n;
        }
    }

    public Node<T> get(int pos) {
        Node<T> temp = first;
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int size() {
        int count = 0;
        Node<T> temp = first;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public Node<T> remove(int pos) {
        Node<T> temp = first;

        if (pos == 0) {
            return temp.getNext();
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.getNext();
            }
            Node<T> temp2 = temp.getNext();
            temp.setNext(temp2.getNext());
            return temp2;
        }
    }

    public Node<T> removeFirst() {
        Node<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public Node<T> removeLast() {
        Node<T> temp = first;
        Node<T> temp2 = first;
        while (temp.getNext() != null) {
            temp2 = temp;
            temp = temp.getNext();
        }
        last = temp2;
        last.setNext(null);
        return temp;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void set(int pos, T d) {
        Node<T> temp = first;
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }
        temp.setData(d);
    }
}
