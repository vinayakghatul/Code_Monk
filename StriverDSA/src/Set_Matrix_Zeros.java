class Set_Matrix_Zeros {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1 : check if first column has any zero
        for (int i=0;i<matrix.length;i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 2 : check if first column has any zero
        for (int j=0;j<matrix[0].length;j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 3 : update matrix (excluding first row, first column), mark zeros for mat[i][j] element
        for (int i=1;i<matrix.length;i++) {
            for (int j=1;j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4 : for marked zeros in step 3, mark rows and columns i.e. actual elements
        for (int i=1;i<matrix.length;i++) {
            for (int j=1;j<matrix[0].length;j++) {
                if (matrix[i][0] ==0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // for first row, make all cols zeros if boolean is true
        if (firstColZero) {
            for (int i=0;i<matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }

        // for first col, make all rows zeros if boolean is treu
        if (firstRowZero) {
            for (int j=0;j<matrix[0].length;j++) {
                matrix[0][j] = 0;
            }
        }

    }
}