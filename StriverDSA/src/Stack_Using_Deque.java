import java.util.*;

class Stack_Using_Deque {

    public static void main(String args[]) {
        int n = 5;

        Deque<Integer> stk = new ArrayDeque<>();

        for (int i=0;i<n;i++) {
            stk.push(i);
        }

        System.out.println(stk);

        stk.pop();

        System.out.println(stk);



    }
}