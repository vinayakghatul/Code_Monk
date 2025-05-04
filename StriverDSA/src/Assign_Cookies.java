import java.util.*;

class Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {

        int n = g.length;
        int m = s.length;

        int i=0,j=0;

        Arrays.sort(g);
        Arrays.sort(s);

        while(i<n && j<m) {
            // check if the size is satisfactory for the child
            // if yes then move to the next child
            if (s[j]>= g[i]) {
                i++;
            }
            // if or if not in both cases we have to move to the next size cookie
            j++;
        }
        return i;
    }

    public static void main (String args[]) {
        int[] g = {1,2};
        int[] s = {1,2,3};

        Assign_Cookies assignCookies = new Assign_Cookies();

        System.out.println(assignCookies.findContentChildren(g, s));

    }

}