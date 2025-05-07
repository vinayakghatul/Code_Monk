import java.util.*;

class All_Palindrome_Strings {

    public boolean isPalindrome(String s, int left, int right) {

        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void backtrack(int start, String s, List<String> path, List<List<String>> result) {

        // base condition
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Similar to finding all possible combinations of string/array except checking for isPalindrome or not condition
        for(int end = start + 1; end<=s.length();end++) {

            if (isPalindrome(s,start,end-1)) {
                path.add(s.substring(start,end));

                backtrack(end,s,path,result);

                path.remove(path.size()-1);
            }
        }

    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(0,s, new ArrayList<String>(), result);

        return result;

    }

    public static void main(String args[]) {
        String s = "aaab";

        All_Palindrome_Strings allPalindromeStrings = new All_Palindrome_Strings();

        System.out.println(allPalindromeStrings.partition(s));
    }
}