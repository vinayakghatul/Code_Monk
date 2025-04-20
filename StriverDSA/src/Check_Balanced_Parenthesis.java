import java.util.*;

class Check_Balanced_Parenthesis {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            } else if (!stk.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                switch(s.charAt(i)) {
                    case ')' : if (stk.peek() == '(') {
                        stk.pop();
                    } else {
                        return false;
                    }
                        break;
                    case '}' : if (stk.peek() == '{') {
                        stk.pop();
                    } else {
                        return false;
                    }
                        break;
                    case ']' : if (stk.peek() == '[') {
                        stk.pop();
                    } else {
                        return false;
                    }
                        break;
                    default : // do nothing
                }
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }

    public static void main(String args[]) {
        String s = "(({}{}[{}]))";

        Check_Balanced_Parenthesis checkBalancedParenthesis = new Check_Balanced_Parenthesis();

        System.out.println(checkBalancedParenthesis.isValid(s));
    }
}