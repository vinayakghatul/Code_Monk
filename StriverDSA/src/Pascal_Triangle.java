import java.util.*;

/**
 * Row 0:        1
 * Row 1:       1 1
 * Row 2:      1 2 1
 * Row 3:     1 3 3 1
 * Row 4:    1 4 6 4 1
 */

class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascal = new ArrayList<>();

        for (int i=0;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();

            for (int j=0;j<=i;j++) {
                // first and last is always 1
                if (j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }

    public static void main(String args[]) {
        Pascal_Triangle pascalTriangle = new Pascal_Triangle();

        System.out.println(pascalTriangle.generate(5));
    }
}