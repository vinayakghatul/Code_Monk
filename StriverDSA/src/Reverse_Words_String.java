import java.util.*;

class Reverse_Words_String {
    public String reverseWords1(String s) {

        String[] words = s.split("\\s+");

        String result = "";

        for(String word : words) {
            result = word + " " + result;
        }

        return result.trim();
    }

    // Using string builder

    public String reverseWords(String s) {

        // Handle extra spaces using '\\s+'
        String[] words = s.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1;i>=0;i--) {
            sb.append(words[i]);

            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String args[]) {
        String s = "this is  sparta ";

        Reverse_Words_String reverseWordsString = new Reverse_Words_String();

        System.out.println(reverseWordsString.reverseWords(s));
    }
}