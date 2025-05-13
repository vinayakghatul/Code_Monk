import java.util.*;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 *
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 *
 * Output: "1211"
 *
 * Explanation:
 *
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 */

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