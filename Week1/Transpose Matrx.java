class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        
        int transRows = cols;
        int transCols = rows;
        
        int[][] transposed = new int[transRows][transCols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = A[i][j];
            }
        }
        
        return transposed;
    }
}