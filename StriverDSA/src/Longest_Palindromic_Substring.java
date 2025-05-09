import java.util.*;

class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        // string length
        int n = s.length();
        // dp array
        boolean[][] dp = new boolean[n][n];

        // to store final answers
        int start = 0, maxLen = 1;

        // array of size 1 is always palindrome
        for (int i=0;i<n;i++) {
            dp[i][i] = true;
        }

        // check for array of size 2
        for (int i=0;i<n-1;i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;

                if (maxLen < 2) {
                    start = i;
                    maxLen = 2;
                }
            }
        }

        // for sunbstrings of size 3 to n
        for (int k=3;k<=n;k++) {
            for (int i=0;i<n-k+1;i++) {
                int j = i+k-1;

                // if substring of i...j (reducing 1 from front and back) is palindrome i.e. dp[i+1][j-1]
                // And chars at i and j match then i...j is also substring
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLen) {
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);

    }

    public static void main(String args[]) {
        String s = "aaabb";

        Longest_Palindromic_Substring longestPalindromicSubstring = new Longest_Palindromic_Substring();

        System.out.println(longestPalindromicSubstring.longestPalindrome(s));
    }
}