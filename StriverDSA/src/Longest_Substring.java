import java.util.*;

/**
 * Longest substring with repeat characters
 *
 * Sliding window method
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