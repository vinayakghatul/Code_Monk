class Rotate_Matrix_90_Anti_Clockwise {
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
            int n = mat.length;

            for (int j = 0; j < n; j++) {
                int top = 0;
                int bottom = n - 1;
                while (top < bottom) {
                    int temp = mat[top][j];
                    mat[top][j] = mat[bottom][j];
                    mat[bottom][j] = temp;
                    top++;
                    bottom--;
                }
            }
            return mat;
        }

        public void rotate(int[][] matrix) {
            matrix = transpose(matrix);
            matrix = reverse(matrix);

            int n = matrix.length;

            //Printing array after rotation
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("\n");
            }
        }

        public static void main(String args[]) {
            int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
            int n = matrix.length;

            Rotate_Matrix_90_Anti_Clockwise rotateMatrix90AntiClockwise = new Rotate_Matrix_90_Anti_Clockwise();

            rotateMatrix90AntiClockwise.rotate(matrix);
        }
}