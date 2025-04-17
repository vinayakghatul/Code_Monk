class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {

        // Base case
        if (strs.length == 0 || strs == null) {
            return "";
        }

        // for each character of first string, match it with each of remaining strings from 1 to n
        // if the match does not happen for any of the string then thats the longest prefix we cna get

        for (int i=0;i<strs[0].length();i++) {
            // for each character of first string
            char c = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++) {
                // if any string length is smaller than the index of first string index
                // Or if character does not match woth c then break;
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }

        }

        return strs[0];
    }

    public static void main(String args[]) {
        Longest_Common_Prefix longestCommonPrefix = new Longest_Common_Prefix();

        String[] input = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(input));
    }
}