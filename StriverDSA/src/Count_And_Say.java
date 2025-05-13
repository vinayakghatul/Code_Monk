import java.util.*;

class Count_And_Say {
    public String countAndSay(int n) {

        // base case
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i=1;i<prev.length();i++) {
            // count repeating chars
            if (prev.charAt(i) == prev.charAt(i-1)) {
                count++;
            } else { // if neighbours are not same then append with prefix for prev char
                sb.append(count);
                sb.append(prev.charAt(i-1));
                count = 1;
            }
        }

        // append last (n-1)th char
        sb.append(count);
        sb.append(prev.charAt(prev.length() - 1));

        return sb.toString();
    }

    public static void main(String args[]) {
        Count_And_Say countAndSay = new Count_And_Say();
        System.out.println(countAndSay.countAndSay(4));
    }
}