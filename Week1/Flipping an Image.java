class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int cols = A.length;
        
        int[][] flipped = new int[rows][cols];
        int[][] flippedAndInverted = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            int end = cols - 1;
            for (int j = 0; j < cols; j++) {
                flipped[i][end] = A[i][j];
                end--; 
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flipped[i][j] == 0) {
                    flippedAndInverted[i][j] = 1;
                } else {
                    flippedAndInverted[i][j] = 0;
                }
            }
        }
        
        return flippedAndInverted;
    }
}