import java.util.*;

class Rotten_Oranges {

    public boolean isSafe(int i, int j, int m, int n) {
        return (i>=0 && i<m && j>=0 && j<n);
    }

    public int orangesRotting(int[][] grid) {

        // m,n matrix

        int m = grid.length;
        int n = grid[0].length;

        // directions to check for each cell
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        // Queue to store rotten oranges
        Queue<int[]> q = new LinkedList<>();

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }

        // start with time 0
        int timeRequired = 0;

        while(!q.isEmpty()) {

            int len = q.size();

            while(len > 0) {
                // current rotten orange
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                // check each direction
                for (int[] dir: directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    // check if neighbour is inside the matrix
                    if (isSafe(x,y,m,n) && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x,y});
                    }
                }

                len--;
            }

            timeRequired++;
        }

        // check if any orange remain that is not rotten
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(0,timeRequired - 1);
    }

    public static void main(String args[]) {

        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };

        Rotten_Oranges rottenOranges = new Rotten_Oranges();
        int rotting = rottenOranges.orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);

    }
}