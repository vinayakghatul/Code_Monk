class Rotate_Matrix_90_Clockwise {
    // step 1 : transpose matrix

    // step 2 : reverse matrix

    // result of step 1 and step 2 is rotated matrix by 90 clockwise

    public int[][] transpose(int[][] mat) {
        int n = mat.length;

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        return mat;
    }

    // Row wise reverse
    public int[][] reverse(int[][] mat) {
        for (int[] row: mat) {
            int left=0;
            int right = row.length -1;
            while(left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }

        return mat;
    }

    public void rotate(int[][] matrix) {
        matrix = transpose(matrix);
        matrix = reverse(matrix);
    }
}