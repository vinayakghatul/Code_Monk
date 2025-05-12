class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            int row = mid/m;
            int col = mid%m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search_2D_Matrix obj = new Search_2D_Matrix();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target1 = 3;
        int target2 = 13;

        System.out.println("Searching for " + target1 + ": " + obj.searchMatrix(matrix, target1)); // true
        System.out.println("Searching for " + target2 + ": " + obj.searchMatrix(matrix, target2)); // false
    }

}