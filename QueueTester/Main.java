package QueueTester;

interface QueueQT {
    // ---------------------------------------------
    // Puts item on end of queue.
    // ---------------------------------------------
    public void add(Object item);

    // ---------------------------------------------
    // Removes and returns object from front of queue.
    // ---------------------------------------------
    public Object remove();

    // ---------------------------------------------
    // Returns true if queue is empty.
    // ---------------------------------------------
    public boolean isEmpty();

    // ---------------------------------------------
    // Returns the front of the queue without removing it.
    // ---------------------------------------------
    public boolean peek();

    // ---------------------------------------------
    // Returns the number of elements in the queue.
    // ---------------------------------------------
    public int size();
}

class Queue implements QueueQT {
    private Object[] queue;
    private int front;
    private int rear;
    private int count;

    public Queue(int size) {
        queue = new Object[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void add(Object item) {
        if (count == queue.length) {
            System.out.println("Queue is full.");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = item;
            count++;
        }
    }

    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            Object item = queue[front];
            front = (front + 1) % queue.length;
            count--;
            return item;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return false;
        } else {
            System.out.println("Front of queue is: " + queue[front]);
            return true;
        }
    }

    public int size() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("D");
        q.add("E");

        System.out.println(q.peek());

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        System.out.println(q.size());
    }
}
