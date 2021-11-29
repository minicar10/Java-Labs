package StackTester;

interface StackInterface<E> {
    public void push(E o);

    public E peek();

    public E pop();

    public E get(int x);

    public int size();

    public boolean empty();
}

// **Question**: Why is there a cast from Object to E in the push method and
// constructor?
// **Rationale**: You cannot create generic arrays, therefore you must cast the
// object to the type of the array.
class Stack<E> implements StackInterface<E> {
    private E[] stack;
    private int top;

    public Stack() {
        stack = (E[]) new Object[10];
        top = -1;
    }

    public void push(E o) {
        if (top == stack.length - 1) {
            E[] temp = (E[]) new Object[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        stack[++top] = o;
    }

    public E peek() {
        if (top == -1) {
            return null;
        }
        return stack[top];
    }

    public E pop() {
        if (top == -1) {
            return null;
        }
        return stack[top--];
    }

    public E get(int x) {
        if (x > top || x < 0) {
            return null;
        }
        return stack[x];
    }

    public int size() {
        return top + 1;
    }

    public boolean empty() {
        return top == -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");

        System.out.println(s.peek());
        System.out.println(s.pop());
        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }
}
