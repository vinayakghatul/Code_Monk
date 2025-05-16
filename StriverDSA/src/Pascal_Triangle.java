import java.util.*;

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