import java.util.*;

class Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        // Solution using constant space int[26] a-z array
        // for first string do increase counter and for second string descrease counter
        // so that net count should be zero for all alphabets

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i=0;i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i=0;i<count.length;i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        // Solution by converting strings to char array
        // then comparing the char array
        // O(nlogn) time, O(1) space
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        if (s.length() != t.length()) {
            return false;
        }

        Arrays.sort(s1);
        Arrays.sort(t1);

        int i=0;
        while(i < s1.length && s1[i] == t1[i]) {
            i++;
        }

        if (i == s1.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        String s = "anagram";
        String t = "nagaram";

        Valid_Anagram validAnagram = new Valid_Anagram();
        System.out.println(validAnagram.isAnagram(s,t));
    }
}