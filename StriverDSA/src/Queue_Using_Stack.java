import java.util.*;

class Queue_Using_Stack{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public Queue_Using_Stack() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        shiftStacks();
        return output.pop();
    }

    public int peek() {
        shiftStacks();
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public void shiftStacks() {
        if (output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String args[]) {
        Queue_Using_Stack queue = new Queue_Using_Stack();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.isEmpty());

        System.out.println(queue.pop());

        System.out.println(queue.peek());
    }
}