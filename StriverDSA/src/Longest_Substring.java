import java.util.*;

/**
 * Longest substring with repeat characters
 *
 * Sliding window method
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

class Longest_Substring {

    public int longestSubstring(String s) {
        Set<Character> hs = new HashSet<>();

        int maxLen=0,left=0,right=0;

        while(right < s.length()) {
            char c = s.charAt(right);

            if (!hs.contains(c)) {
                hs.add(c);
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                hs.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;

    }

    public static void main(String args[]) {

        String s = "abcabcbb";

        Longest_Substring longestSubstring = new Longest_Substring();

        System.out.println(longestSubstring.longestSubstring(s));

    }
}