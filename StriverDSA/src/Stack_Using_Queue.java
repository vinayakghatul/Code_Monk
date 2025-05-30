import java.util.*;

class Stack_Using_Queue {

    Queue<Integer> q = new LinkedList<>();

    public Stack_Using_Queue() {

    }

    // push method
    public void push(int x) {
        q.add(x);
        for (int i=1;i<q.size();i++) {
            q.add(q.remove());
        }
    }

    // pop method
    public int pop() {
        return q.remove();
    }

    // peek method or top method
    public int peek() {
        return q.peek();
    }

    // is empty check method
    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String args[]) {
        Stack_Using_Queue stack = new Stack_Using_Queue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
    }
}